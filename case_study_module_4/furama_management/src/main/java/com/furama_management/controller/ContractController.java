package com.furama_management.controller;

import com.furama_management.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;

    @GetMapping("/list")
    public String showListContract(Model model,@PageableDefault(size = 3,page = 0) Pageable pageable){
        model.addAttribute("listContract",contractService.listContract(pageable));
        return "contract/list";
    }

}
