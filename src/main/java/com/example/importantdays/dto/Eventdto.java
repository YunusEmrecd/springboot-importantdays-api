package com.example.importantdays.dto;

import java.time.LocalDate;

public class Eventdto {
    private long id;
    private String name;
    private String description;
    private LocalDate date;

    public Eventdto(long id, String name, String description, LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Eventdto(long id, String name, LocalDate date) {
        this.name = name;
        this.date = date;
        this.description = null;

    }
    public Eventdto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
