package com.example.demo.service;

import com.example.demo.dto.ThueTroDTO1;
import com.example.demo.model.HinhThucThanhToan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IHinhThucThanhToanService extends IGeneralService<HinhThucThanhToan> {
    List<HinhThucThanhToan> findAll();
}
