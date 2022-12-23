package com.exercise_2.service;

import com.exercise_2.model.Song;
import com.exercise_2.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SongServiceImpl implements ISongService{
    @Autowired
    ISongRepository songRepository;
    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public Optional findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(int id) {
        songRepository.deleteById(id);

    }
}
