package com.preciado.snek_watch_api.model;

import java.time.LocalDate;

public class Snake {
    private long id;
    private String name;
    private LocalDate dob;
    // private long snakeTypeId; <-- something to this effect...
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    
}
