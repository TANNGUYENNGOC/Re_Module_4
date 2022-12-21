package com.example.demo.repository;

import com.example.demo.dto.ThueTroDTO1;
import com.example.demo.model.ThueTro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IThueTroRepository extends JpaRepository<ThueTro,Integer> {
    @Query(value = "SELECT tt.id,tt.ten_nguoi_thue_tro as tenNguoiThueTro,tt.so_dien_thoai as soDienThoai,tt.ngay_bat_dau_thue as ngayBatDauThue,httt.ten_hinh_thuc_thanh_toan as hinhThucThanhToan FROM thue_tro tt JOIN hinh_thuc_thanh_toan httt ON tt.hinh_thuc_thanh_toan_id = httt.id WHERE tt.id like concat('%',:id,'%') and (tt.ten_nguoi_thue_tro like concat('%',:tenNguoiThueTro,'%') and tt.so_dien_thoai like concat('%',:soDienThoai,'%'))"
            , countQuery = "select * from (SELECT tt.id,tt.ten_nguoi_thue_tro as tenNguoiThueTro,tt.so_dien_thoai as soDienThoai,tt.ngay_bat_dau_thue as ngayBatDauThue,httt.ten_hinh_thuc_thanh_toan as hinhThucThanhToan FROM thue_tro tt JOIN hinh_thuc_thanh_toan httt ON tt.hinh_thuc_thanh_toan_id = httt.id WHERE tt.id like concat('%',:id,'%') and (tt.ten_nguoi_thue_tro like concat('%',:tenNguoiThueTro,'%') and tt.so_dien_thoai like concat('%',:soDienThoai,'%')))abc"
            , nativeQuery = true)
    Page<ThueTroDTO1> listSearch(Pageable pageable, @Param("id") String id, @Param("tenNguoiThueTro") String tenNguoiThueTro, @Param("soDienThoai") String soDienThoai);
}
