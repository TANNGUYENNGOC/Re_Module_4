package com.exercise_2.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String nameSong;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String singer;
    @Column(columnDefinition = "TEXT")
    private String category;

    public Song(int id, String nameSong, String singer, String category) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
    }

    public Song(String nameSong, String singer, String category) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
    }

    public Song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
