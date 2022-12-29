package com.furama_management.service.employee;

import com.furama_management.model.employee.Employee;
import com.furama_management.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    IEmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
