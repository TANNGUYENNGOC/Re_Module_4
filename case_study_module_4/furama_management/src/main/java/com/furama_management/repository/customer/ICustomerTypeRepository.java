package com.furama_management.repository.customer;

import com.furama_management.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
    List<CustomerType> findAll();
}
