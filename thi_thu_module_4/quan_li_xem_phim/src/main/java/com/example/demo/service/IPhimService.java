package com.example.demo.service;

import com.example.demo.model.Phim;

import java.util.List;

public interface IPhimService extends IGeneralService<Phim>{
    List<Phim> findAll();
}
