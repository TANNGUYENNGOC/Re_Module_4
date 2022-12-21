package com.example.demo.service.impl;

import com.example.demo.dto.ThueTroDTO1;
import com.example.demo.model.HinhThucThanhToan;
import com.example.demo.repository.IHinhThucThanhToanRepository;
import com.example.demo.service.IHinhThucThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HinhThucThanhToanService implements IHinhThucThanhToanService {
    @Autowired
    IHinhThucThanhToanRepository hinhThucThanhToanRepository;
    @Override
    public Page<HinhThucThanhToan> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<HinhThucThanhToan> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(HinhThucThanhToan hinhThucThanhToan) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<HinhThucThanhToan> findAll() {
        return hinhThucThanhToanRepository.findAll();
    }

}
