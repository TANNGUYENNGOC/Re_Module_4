package com.exercise.repository;

import com.exercise.model.BorrowAndPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowAndPayRepository extends JpaRepository<BorrowAndPay,Integer> {
    @Query(value = "select * from borrow_and_pay where code = :code",
    countQuery = "select * from (select * from borrow_and_pay where code = :code)borrowAndPay"
    ,nativeQuery = true)
    BorrowAndPay borrowAndPay (@Param("code")int code);
}
