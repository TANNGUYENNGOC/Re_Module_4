package com.exercise.service.borrowAndPay;

import com.exercise.model.Order;
import com.exercise.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderRepository borrowAndPayRepository;
    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return borrowAndPayRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        borrowAndPayRepository.save(order);
    }

    @Override
    public void remove(Integer id) {
        borrowAndPayRepository.deleteById(id);
    }

    @Override
    public Order borrowAndPay(int code) {
        return borrowAndPayRepository.borrowAndPay(code);
    }
}
