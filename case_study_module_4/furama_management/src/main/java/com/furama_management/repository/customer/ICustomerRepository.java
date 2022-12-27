package com.furama_management.repository.customer;

import com.furama_management.dto.customer.CustomerDTO1;
import com.furama_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select customer.id,ct.name as customerType,customer.name,customer.date_of_birth as dateOfBirth,customer.gender,customer.id_card as idCard,customer.phone_number as phoneNumber,customer.email,customer.address from customer join customer_type ct on ct.id = customer.customer_type_id where (customer.name like concat('%',:nameCustomer,'%') and ct.name like concat('%',:customerType,'%') and customer.email like concat('%',:emailCustomer,'%')) and customer.flag=0"
            , countQuery ="select * from (select customer.id,ct.name as customerType,customer.name,customer.date_of_birth as dateOfBirth,customer.gender,customer.id_card as idCard,customer.phone_number as phoneNumber,customer.email,customer.address from customer join customer_type ct on ct.id = customer.customer_type_id where (customer.name like concat('%',:nameCustomer,'%') and ct.name like concat('%',:customerType,'%') and customer.email like concat('%',:emailCustomer,'%')) and customer.flag=0)customer"
            , nativeQuery = true)
    Page<CustomerDTO1> listCustomer(Pageable pageable, @Param("nameCustomer") String nameCustomer,@Param("emailCustomer")String emailCustomer ,@Param("customerType") String customerType);
}
