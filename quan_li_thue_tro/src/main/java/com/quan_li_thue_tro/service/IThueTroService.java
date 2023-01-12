package com.quan_li_thue_tro.service;

import com.quan_li_thue_tro.model.ThueTro;
import dto.IThueTroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IThueTroService extends IGeneralService<ThueTro>{
    Page<IThueTroDTO> listThueTro(String tenNguoiThueTro,String tenHinhThucThanhToan, Pageable pageable);

}
