package com.example.demo.model;

import javax.persistence.*;

@Entity
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String tenHinhThucThanhToan;

    public HinhThucThanhToan(int maHinhThucThanhToan, String tenHinhThucThanhToan) {
        this.id = maHinhThucThanhToan;
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
    }

    public HinhThucThanhToan(int id) {
        this.id = id;
    }

    public HinhThucThanhToan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int maHinhThucThanhToan) {
        this.id = maHinhThucThanhToan;
    }

    public String getTenHinhThucThanhToan() {
        return tenHinhThucThanhToan;
    }

    public void setTenHinhThucThanhToan(String hinhThucThanhToan) {
        this.tenHinhThucThanhToan = hinhThucThanhToan;
    }
}
