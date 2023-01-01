package com.furama_management.repository.customer;

import com.furama_management.dto.attach_facility.IAttachFacilityCustomer;
import com.furama_management.dto.customer.CustomerDTO1;
import com.furama_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select customer.id,ct.name as customerType,customer.name,customer.date_of_birth as dateOfBirth,customer.gender,customer.id_card as idCard,customer.phone_number as phoneNumber,customer.email,customer.address from customer join customer_type ct on ct.id = customer.customer_type_id where (customer.name like concat('%',:nameCustomer,'%') and ct.name like concat('%',:customerType,'%') and customer.email like concat('%',:emailCustomer,'%')) and customer.flag=0"
            , countQuery ="select * from (select customer.id,ct.name as customerType,customer.name,customer.date_of_birth as dateOfBirth,customer.gender,customer.id_card as idCard,customer.phone_number as phoneNumber,customer.email,customer.address from customer join customer_type ct on ct.id = customer.customer_type_id where (customer.name like concat('%',:nameCustomer,'%') and ct.name like concat('%',:customerType,'%') and customer.email like concat('%',:emailCustomer,'%')) and customer.flag=0)customer"
            , nativeQuery = true)
    Page<CustomerDTO1> listCustomer(Pageable pageable, @Param("nameCustomer") String nameCustomer,@Param("emailCustomer")String emailCustomer ,@Param("customerType") String customerType);

    @Query(value = "select customer.id,ct.name as customerType,customer.name,customer.date_of_birth as dateOfBirth,customer.gender,customer.id_card as idCard,customer.phone_number as phoneNumber,customer.email,customer.address from customer join customer_type ct on ct.id = customer.customer_type_id where customer.flag=0"
            , countQuery ="select * from (select customer.id,ct.name as customerType,customer.name,customer.date_of_birth as dateOfBirth,customer.gender,customer.id_card as idCard,customer.phone_number as phoneNumber,customer.email,customer.address from customer join customer_type ct on ct.id = customer.customer_type_id where customer.flag=0)customer"
            , nativeQuery = true)
    List<CustomerDTO1> listCustomer ();

    @Query(value = "SELECT  c.flag,c.id, ct.name as customerType, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c  JOIN customer_type ct ON c.customer_type_id = ct.id join contract c2 on c.id = c2.customer_id where c.flag=0 group by c.id"
            , countQuery = "select * from(SELECT  c.flag,c.id, ct.name as customerType, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c  JOIN customer_type ct ON c.customer_type_id = ct.id join contract c2 on c.id = c2.customer_id where c.flag=0 group by c.id)abc"
            , nativeQuery = true)
    Page<CustomerDTO1> listCustomerJoinContract(Pageable pageable);

    @Query(value = "select attach_facility.name,attach_facility.cost,attach_facility.unit,attach_facility.status  from attach_facility join contract_detail cd on attach_facility.id = cd.attach_facility_id join contract c on cd.contract_id = c.id join customer c2 on c.customer_id = c2.id where c2.id=:id"
            , countQuery = "select * from(select attach_facility.name,attach_facility.cost,attach_facility.unit,attach_facility.status  from attach_facility join contract_detail cd on attach_facility.id = cd.attach_facility_id join contract c on cd.contract_id = c.id join customer c2 on c.customer_id = c2.id where c2.id=:id)abc"
            , nativeQuery = true)
    List<IAttachFacilityCustomer> listAttachFacility(@Param("id") int id);

}
