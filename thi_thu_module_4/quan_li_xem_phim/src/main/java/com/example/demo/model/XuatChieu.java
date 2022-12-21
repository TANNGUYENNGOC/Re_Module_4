package com.example.demo.model;

import javax.persistence.*;

@Entity
public class XuatChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Phim phim;
    @Column(columnDefinition = "DATE")
    private String ngayChieu;
    private int soLuongVe;

    public XuatChieu(int id, Phim phim, String ngayChieu, int soLuongVe) {
        this.id = id;
        this.phim = phim;
        this.ngayChieu = ngayChieu;
        this.soLuongVe = soLuongVe;
    }

    public XuatChieu() {
    }

    public XuatChieu(Phim phim, String ngayChieu, int soLuongVe) {
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
