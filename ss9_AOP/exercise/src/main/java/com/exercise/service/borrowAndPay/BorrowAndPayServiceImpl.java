package com.exercise.service.borrowAndPay;

import com.exercise.model.BorrowAndPay;
import com.exercise.repository.IBorrowAndPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowAndPayServiceImpl implements IBorrowAndPayService {
    @Autowired
    IBorrowAndPayRepository borrowAndPayRepository;
    @Override
    public Page<BorrowAndPay> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<BorrowAndPay> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(BorrowAndPay borrowAndPay) {
        borrowAndPayRepository.save(borrowAndPay);
    }

    @Override
    public void remove(Integer id) {

    }
}
