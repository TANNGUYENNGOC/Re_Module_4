package com.furama_management.controller;

import com.furama_management.dto.customer.CustomerDTO;
import com.furama_management.dto.customer.CustomerDTO1;
import com.furama_management.model.customer.Customer;
import com.furama_management.service.attach_facility.IAttachFacilityService;
import com.furama_management.service.customer.ICustomerService;
import com.furama_management.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class customerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("{id}/listAttachFacility")
    public String listAttachFacility(Model model
            , @PageableDefault(page = 0, size = 3) Pageable pageable
            , @PathVariable("id") int id) {
        model.addAttribute("list", customerService.listAttachFacility(id));
        return "attach_facility/list";
    }

    @GetMapping("/listCustomer")
    public String showListCustomer(@RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "") String email,
                                   @RequestParam(defaultValue = "") String customerTypeName,
                                   @PageableDefault(size = 3, page = 0) Pageable pageable,
                                   Model model) {
        model.addAttribute("customers", customerService.listCustomer(pageable, name, email, customerTypeName));
        model.addAttribute("listCustomerType", customerTypeService.findAll());
        model.addAttribute("customerTypeName", customerTypeName);
        model.addAttribute("customerDTO", new CustomerDTO());
        return "customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model, Pageable pageable) {
        model.addAttribute("customerDTO", new CustomerDTO());
        model.addAttribute("listCustomerType", customerTypeService.findAll(pageable));
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute("customerDTO") CustomerDTO customerDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model, @RequestParam(defaultValue = "") String name,
                                 @RequestParam(defaultValue = "") String email,
                                 @RequestParam(defaultValue = "") String customerTypeName,
                                 @PageableDefault(size = 3, page = 0) Pageable pageable) {
        new CustomerDTO().checkDuplicate(customerService.findAll(),customerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCustomerType", customerTypeService.findAll());
            model.addAttribute("modal", true);
            model.addAttribute("customers", customerService.listCustomer(pageable, name, email, customerTypeName));
            model.addAttribute("listCustomerType", customerTypeService.findAll());
            model.addAttribute("customerTypeName", customerTypeName);
            return "customer/list";

        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/customer/listCustomer";
    }

    @PostMapping("/remove")
    public String removeCustomer(@RequestParam("idRemove") int id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id).get();
        customer.setFlag(true);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công khách hàng " + customer.getName());
        return "redirect:/customer/listCustomer";
    }

    @GetMapping("{id}/update")
    public String showFormupdateCustomer(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findById(id).get();
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        model.addAttribute("customerDTO", customerDTO);
        model.addAttribute("listCustomerType", customerTypeService.findAll());
        return "customer/update";
    }

    @PostMapping("/update")
    public String updateCustomer(@Validated @ModelAttribute("customerDTO") CustomerDTO customerDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        customerDTO.validate(customerDTO,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("listCustomerType", customerTypeService.findAll());
            return "customer/update";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/customer/listCustomer";
    }

    @GetMapping("/listCustomerJoinContract")
    public String listCustomerJoinContract(Model model, @PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<CustomerDTO1> customerDTO1s = customerService.listCustomerJoinContract(pageable);
        model.addAttribute("customers", customerDTO1s);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/list1";
    }

//    @ExceptionHandler(Exception.class)
//    public String handlerError(Exception e){
//        return "customer/error";
//    }
}
