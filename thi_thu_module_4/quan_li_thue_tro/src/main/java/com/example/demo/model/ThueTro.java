package com.example.demo.model;

import javax.persistence.*;

@Entity
public class ThueTro {
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

    public ThueTro(int id, String tenNguoiThueTro, String soDienThoai, String ngayBatDauThue, HinhThucThanhToan hinhThucThanhToan) {
        this.id = id;
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThue = ngayBatDauThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public ThueTro(String tenNguoiThueTro, String soDienThoai, String ngayBatDauThue, HinhThucThanhToan hinhThucThanhToan) {
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThue = ngayBatDauThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public ThueTro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int maPhongTro) {
        this.id = maPhongTro;
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
}
