package com.quan_li_thue_tro.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
public class ThueTro implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String tenNguoiThueTro;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String soDienThoai;
    @Column(columnDefinition = "DATE")
    private String ngayBatDauThue;
    @ManyToOne
    private HinhThucThanhToan hinhThucThanhToan;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String ghiChu;


    public ThueTro(int id, String tenNguoiThueTro, String soDienThoai, String ngayBatDauThue, HinhThucThanhToan hinhThucThanhToan, String ghiChu) {
        this.id = id;
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThue = ngayBatDauThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
    }

    public ThueTro(String tenNguoiThueTro, String soDienThoai, String ngayBatDauThue, HinhThucThanhToan hinhThucThanhToan, String ghiChu) {
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThue = ngayBatDauThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
    }

    public ThueTro() {
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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ThueTro thueTro =(ThueTro) target;
        if(thueTro.getTenNguoiThueTro().equals("")){
            errors.rejectValue("tenNguoiThueTro","tenNguoiThueTro","Tên người thuê trọ không được để trống");
        }
        if (thueTro.getSoDienThoai().equals("")){
            errors.rejectValue("soDienThoai","soDienThoai","Số điện thoại không được để trống");
        }
        if(thueTro.getNgayBatDauThue().equals("")){
            errors.rejectValue("ngayBatDauThue","ngayBatDauThue","Ngày bắt đâu thuê không được để trống");
        }
    }
}
