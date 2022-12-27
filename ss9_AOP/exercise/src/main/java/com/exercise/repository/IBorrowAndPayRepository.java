package com.exercise.repository;

import com.exercise.model.BorrowAndPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowAndPayRepository extends JpaRepository<BorrowAndPay,Integer> {
}
