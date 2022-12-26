package com.furama_management.service.customer;

import com.furama_management.model.customer.CustomerType;
import com.furama_management.service.IGeneralService;

import java.util.List;

public interface ICustomerTypeService extends IGeneralService<CustomerType> {
    List<CustomerType> findAll();
}
