package com.quan_li_thue_tro.repository;

import com.quan_li_thue_tro.model.ThueTro;
import dto.IThueTroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IThueTroRepository extends JpaRepository<ThueTro, Integer> {
    @Query(value = "select thue_tro.id,thue_tro.ten_nguoi_thue_tro as tenNguoiThueTro,thue_tro.so_dien_thoai as soDienThoai,thue_tro.ngay_bat_dau_thue as ngayBatDauThue,httt.ten_hinh_thuc_thanh_toan as tenHinhThucThanhToan,thue_tro.ghi_chu as ghiChu from thue_tro join hinh_thuc_thanh_toan httt on httt.id = thue_tro.hinh_thuc_thanh_toan_id where thue_tro.ten_nguoi_thue_tro like concat('%',:tenNguoiThueTro,'%') and httt.ten_hinh_thuc_thanh_toan like concat('%',:tenHinhThucThanhToan,'%')"
            , countQuery = "select * from (select thue_tro.id,thue_tro.ten_nguoi_thue_tro as tenNguoiThueTro,thue_tro.so_dien_thoai as soDienThoai,thue_tro.ngay_bat_dau_thue as ngayBatDauThue,httt.ten_hinh_thuc_thanh_toan as tenHinhThucThanhToan,thue_tro.ghi_chu as ghiChu from thue_tro join hinh_thuc_thanh_toan httt on httt.id = thue_tro.hinh_thuc_thanh_toan_id where thue_tro.ten_nguoi_thue_tro like concat('%',:tenNguoiThueTro,'%') and httt.ten_hinh_thuc_thanh_toan like concat('%',:tenHinhThucThanhToan,'%'))abc"
            , nativeQuery = true)
    Page<IThueTroDTO> listThueTro(@Param("tenNguoiThueTro") String tenNguoiThueTro, @Param("tenHinhThucThanhToan")String tenHinhThucThanhToan, Pageable pageable);
}
