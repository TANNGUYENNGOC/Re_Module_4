package com.furama_management.service.customer;

import com.furama_management.model.customer.CustomerType;
import com.furama_management.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService{
    @Autowired
    ICustomerTypeRepository customerTypeRepository;
    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return customerTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<CustomerType> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void remove(int id) {

    }
}
