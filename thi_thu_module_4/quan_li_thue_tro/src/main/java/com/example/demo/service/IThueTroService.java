package com.example.demo.service;

import com.example.demo.dto.ThueTroDTO1;
import com.example.demo.model.ThueTro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IThueTroService extends IGeneralService<ThueTro>{
    Page<ThueTroDTO1> listSearch(Pageable pageable, String id, String tenNguoiThueTro, String soDienThoai);

}
