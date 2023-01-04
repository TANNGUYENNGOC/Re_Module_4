package com.furama_management.service.customer;

import com.furama_management.dto.attach_facility.IAttachFacilityCustomer;
import com.furama_management.dto.customer.CustomerDTO1;
import com.furama_management.model.customer.Customer;
import com.furama_management.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Page<CustomerDTO1> listCustomer(Pageable pageable, String nameCustomer, String emailCustomer, String customerType) {
        return customerRepository.listCustomer(pageable,nameCustomer,emailCustomer,customerType);
    }

    @Override
    public List<CustomerDTO1> listCustomer() {
        return customerRepository.listCustomer();
    }

    @Override
    public Page<CustomerDTO1> listCustomerJoinContract(Pageable pageable) {
        return customerRepository.listCustomerJoinContract(pageable);
    }

    @Override
    public List<IAttachFacilityCustomer> listAttachFacility(int id) {
        return customerRepository.listAttachFacility(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
