package com.furama_management.controller;

import com.furama_management.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list")
    public String showListEmployee(Model model, Pageable pageable){
        model.addAttribute("listEmployee",employeeService.findAll(pageable));
        return "employee/list";
    }
}
