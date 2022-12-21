package com.example.demo.dto;

import com.example.demo.model.Phim;


public class XuatChieuDto {
    private int id;
    private Phim phim;
    private String ngayChieu;
    private int soLuongVe;

    public XuatChieuDto() {
    }

    public XuatChieuDto(int id, Phim phim, String ngayChieu, int soLuongVe) {
        this.id = id;
        this.phim = phim;
        this.ngayChieu = ngayChieu;
        this.soLuongVe = soLuongVe;
    }

    public XuatChieuDto(Phim phim, String ngayChieu, int soLuongVe) {
        this.phim = phim;
        this.ngayChieu = ngayChieu;
        this.soLuongVe = soLuongVe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }
}
