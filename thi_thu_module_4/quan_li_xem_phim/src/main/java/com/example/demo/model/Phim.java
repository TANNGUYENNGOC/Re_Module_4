package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenPhim;

    public Phim(int id, String tenPhim) {
        this.id = id;
        this.tenPhim = tenPhim;
    }

    public Phim() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }
}
