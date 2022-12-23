package com.exercise_2.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO {
    private int id;
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Tên bài hát không được chưa kí tự đặc biêt")
    private String nameSong;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 300,message = "Tên bài hát không được quá 300 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "Tên bài hát không được chưa kí tự đặc biêt")
    private String singer;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 1000,message = "Tên bài hát không được quá 1000 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9, ]*$",message = "Tên bài hát không được chưa kí tự đặc biêt (chỉ được chứa dấu phẩy)")
    private String category;

    public SongDTO(int id, String nameSong, String singer, String category) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
    }

    public SongDTO(String nameSong, String singer, String category) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
    }

    public SongDTO() {
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
