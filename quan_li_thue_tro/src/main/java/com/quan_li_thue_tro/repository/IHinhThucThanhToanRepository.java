package com.quan_li_thue_tro.repository;

import com.quan_li_thue_tro.model.HinhThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHinhThucThanhToanRepository extends JpaRepository<HinhThucThanhToan,Integer> {
    List<HinhThucThanhToan> findAll();
}
