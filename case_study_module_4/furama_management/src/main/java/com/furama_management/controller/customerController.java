package com.furama_management.controller;

import com.furama_management.dto.customer.CustomerDTO;
import com.furama_management.model.customer.Customer;
import com.furama_management.service.customer.ICustomerService;
import com.furama_management.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class customerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/listCustomer")
    public String showListCustomer(@RequestParam(defaultValue = "")String name,
                                   @RequestParam(defaultValue = "")String email,
                                   @RequestParam(defaultValue = "")String customerTypeName,
                                   @PageableDefault(size = 3,page = 0) Pageable pageable,
                                   Model model){
        model.addAttribute("listCustomer",customerService.listCustomer(pageable,name,email,customerTypeName));
        model.addAttribute("listCustomerType",customerTypeService.findAll());
        model.addAttribute("customerTypeName",customerTypeName);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model,Pageable pageable){
        model.addAttribute("customerDTO",new CustomerDTO());
        model.addAttribute("listCustomerType",customerTypeService.findAll(pageable));
        return "customer/create";
    }
    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customerDTO") CustomerDTO customerDTO, RedirectAttributes redirectAttributes){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/customer/listCustomer";
    }

    @PostMapping("/remove")
    public String removeCustomer(@RequestParam("idRemove") int id,RedirectAttributes redirectAttributes){
        Customer customer = customerService.findById(id).get();
        customer.setFlag(true);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công khách hàng "+customer.getName());
        return "redirect:/customer/listCustomer";
    }

    @GetMapping("{id}/update")
    public String showFormupdateCustomer(@PathVariable("id") int id,Model model){
        Customer customer = customerService.findById(id).get();
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        model.addAttribute("customerDTO",customerDTO);
        model.addAttribute("listCustomerType",customerTypeService.findAll());
        return "customer/update";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customerDTO") CustomerDTO customerDTO,RedirectAttributes redirectAttributes){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/customer/listCustomer";
    }
}
