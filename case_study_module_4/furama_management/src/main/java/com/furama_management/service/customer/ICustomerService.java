package com.furama_management.service.customer;

import com.furama_management.dto.customer.CustomerDTO1;
import com.furama_management.model.customer.Customer;
import com.furama_management.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<CustomerDTO1> listCustomer(Pageable pageable, String nameCustomer,String emailCustomer ,String customerType);
}
