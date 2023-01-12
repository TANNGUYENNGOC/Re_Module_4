package com.quan_li_thue_tro.service.impl;

import com.quan_li_thue_tro.model.ThueTro;
import com.quan_li_thue_tro.repository.IThueTroRepository;
import com.quan_li_thue_tro.service.IThueTroService;
import dto.IThueTroDTO;
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
    public Page findAll(Pageable pageable) {
        return thueTroRepository.findAll(pageable);
    }

    @Override
    public Optional findById(Integer id) {
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
    public Page<IThueTroDTO> listThueTro(String tenNguoiThueTro, String tenHinhThucThanhToan, Pageable pageable) {
        return thueTroRepository.listThueTro(tenNguoiThueTro,tenHinhThucThanhToan,pageable);
    }
}
