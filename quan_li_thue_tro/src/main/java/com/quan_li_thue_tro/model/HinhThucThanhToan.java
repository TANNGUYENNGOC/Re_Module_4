package com.quan_li_thue_tro.model;

import javax.persistence.*;

@Entity
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String tenHinhThucThanhToan;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(int id, String tenHinhThucThanhToan) {
        this.id = id;
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
    }

    public HinhThucThanhToan(String tenHinhThucThanhToan) {
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHinhThucThanhToan() {
        return tenHinhThucThanhToan;
    }

    public void setTenHinhThucThanhToan(String tenHinhThucThanhToan) {
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
    }
}
