package com.example.demo.service.impl;

import com.example.demo.dto.ThueTroDTO1;
import com.example.demo.model.ThueTro;
import com.example.demo.repository.IThueTroRepository;
import com.example.demo.service.IThueTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ThueTroService implements IThueTroService {
    @Autowired
    IThueTroRepository thueTroRepository;
    @Override
    public Page<ThueTro> findAll(Pageable pageable) {
        return thueTroRepository.findAll(pageable);
    }

    @Override
    public Optional<ThueTro> findById(Integer id) {
        return thueTroRepository.findById(id);
    }

    @Override
    public void save(ThueTro thueTro) {
        thueTroRepository.save(thueTro);
    }

    @Override
    public void remove(Integer id) {
        thueTroRepository.deleteById(id);
    }

    @Override
    public Page<ThueTroDTO1> listSearch(Pageable pageable, String id, String tenNguoiThueTro, String soDienThoai) {
        return thueTroRepository.listSearch(pageable,id,tenNguoiThueTro,soDienThoai);
    }
}
