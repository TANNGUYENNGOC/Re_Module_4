package com.example.demo.dto;

import com.example.demo.model.HinhThucThanhToan;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

public class ThueTroDto implements Validator {
    private int id;

    private String tenNguoiThueTro;

    private String soDienThoai;

    private String ngayBatDauThue;

    private HinhThucThanhToan hinhThucThanhToan;

    public ThueTroDto(int id, String tenNguoiThueTro, String soDienThoai, String ngayBatDauThue, HinhThucThanhToan hinhThucThanhToan) {
        this.id = id;
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThue = ngayBatDauThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public ThueTroDto(String tenNguoiThueTro, String soDienThoai, String ngayBatDauThue, HinhThucThanhToan hinhThucThanhToan) {
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThue = ngayBatDauThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public ThueTroDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNguoiThueTro() {
        return tenNguoiThueTro;
    }

    public void setTenNguoiThueTro(String tenNguoiThueTro) {
        this.tenNguoiThueTro = tenNguoiThueTro;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgayBatDauThue() {
        return ngayBatDauThue;
    }

    public void setNgayBatDauThue(String ngayBatDauThue) {
        this.ngayBatDauThue = ngayBatDauThue;
    }

    public HinhThucThanhToan getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ThueTroDto thueTroDto = (ThueTroDto) target;
        // Validate name
        if (thueTroDto.getTenNguoiThueTro().matches("")) {
            errors.rejectValue("tenNguoiThueTro", "tenNguoiThueTro", "Tên người thuê trọ không được để trống.");
        } else if (!thueTroDto.getTenNguoiThueTro().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("tenNguoiThueTro", "tenNguoiThueTro", "Tên người thuê trọ không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa.");
        }

        //Validate số điện thoại
        if (thueTroDto.getSoDienThoai().matches("")) {
            errors.rejectValue("soDienThoai", "soDienThoai", "Số điện thoại không được để trống");
        } else if (!thueTroDto.getSoDienThoai().matches("^0[0-9]{9}$")) {
            errors.rejectValue("soDienThoai", "soDienThoai", "Số điện thoại phải bắt đầu bằng 0 và có 10 số");
        }

        //Validate ngày
        String ngayBatDauThue = thueTroDto.getNgayBatDauThue();
        if (ngayBatDauThue.matches("")) {
            errors.rejectValue("ngayBatDauThue", "ngayBatDauThue", "Vui lòng chọn ngày bắt đầu thuê");
        }
    }
}
