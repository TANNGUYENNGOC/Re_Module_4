package com.quan_li_thue_tro.service;

import com.quan_li_thue_tro.model.HinhThucThanhToan;

import java.util.List;

public interface IHinhThucThanhToanService extends IGeneralService<HinhThucThanhToan>{
    List<HinhThucThanhToan> findAll();

}
