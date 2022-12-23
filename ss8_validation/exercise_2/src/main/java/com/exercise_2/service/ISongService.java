package com.exercise_2.service;

import com.exercise_2.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);
    Optional findById(int id);
    void save(Song song);
    void remove(int id);
}
