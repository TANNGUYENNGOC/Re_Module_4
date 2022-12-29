package com.furama_management.service.employee;

import com.furama_management.model.employee.Employee;
import com.furama_management.service.IGeneralService;

import java.util.List;

public interface IEmployeeService extends IGeneralService<Employee> {
    List<Employee> findAll();
}
