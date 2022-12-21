package com.example.demo.service.impl;

import com.example.demo.model.XuatChieu;
import com.example.demo.repository.IXuatChieuRepository;
import com.example.demo.service.IXuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class XuatChieuService implements IXuatChieuService {
    @Autowired
    IXuatChieuRepository xuatChieuRepository;
    @Override
    public Page<XuatChieu> findAll(Pageable pageable) {
        return xuatChieuRepository.findAll(pageable);
    }

    @Override
    public Optional<XuatChieu> findById(Integer id) {
        return xuatChieuRepository.findById(id);
    }

    @Override
    public void save(XuatChieu xuatChieu) {
        xuatChieuRepository.save(xuatChieu);
    }

    @Override
    public void remove(Integer id) {
        xuatChieuRepository.deleteById(id);
    }
}
