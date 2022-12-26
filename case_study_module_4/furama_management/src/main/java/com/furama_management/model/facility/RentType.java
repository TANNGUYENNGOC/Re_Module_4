package com.furama_management.model.facility;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RentType {
    @Id
    private int id;
    private String name;

    public RentType() {
    }

    public RentType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
