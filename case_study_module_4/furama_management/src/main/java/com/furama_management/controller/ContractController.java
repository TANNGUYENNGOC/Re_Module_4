package com.furama_management.controller;

import com.furama_management.dto.contract.ContractDto;
import com.furama_management.model.contract.Contract;
import com.furama_management.model.contract.ContractDetail;
import com.furama_management.service.attach_facility.IAttachFacilityService;
import com.furama_management.service.contract.IContractService;
import com.furama_management.service.contract_detail.IContractDetailService;
import com.furama_management.service.customer.ICustomerService;
import com.furama_management.service.employee.IEmployeeService;
import com.furama_management.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/list")
    public String showListContract(Model model, @PageableDefault(size = 3, page = 0) Pageable pageable) {

        model.addAttribute("listContract", contractService.listContract(pageable));
        model.addAttribute("contractDTO", new ContractDto());
        model.addAttribute("listCustomer", customerService.listCustomer());
        model.addAttribute("listEmployee", employeeService.findAll());
        model.addAttribute("listFacility", facilityService.listFacility());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("attachFacilityList", attachFacilityService.findAll());
        return "contract/list";
    }

    @PostMapping("/create")
    public String createContract(@Validated @ModelAttribute("contractDTO") ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model,
                                 @PageableDefault(size = 3, page = 0) Pageable pageable) {
        contractDto.validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCustomer", customerService.listCustomer());
            model.addAttribute("listEmployee", employeeService.findAll());
            model.addAttribute("listFacility", facilityService.listFacility());
            model.addAttribute("contractDetail", new ContractDetail());
//            model.addAttribute("attachFacilityList",attachFacilityService.findAll());
            model.addAttribute("modalCreateContract", true);
            model.addAttribute("listContract", contractService.listContract(pageable));

            return "contract/list";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/contract/list";
    }

    @PostMapping("createContractDetail")
    public String createContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/contract/list";
    }
}
