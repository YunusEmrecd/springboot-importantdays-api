package com.example.importantdays.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long ıd;
    public String name;
    public String description;
    public LocalDate date;

    public Event(long ıd, String name, String description, LocalDate date) {
        this.ıd = ıd;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Event(long ıd, String name, LocalDate date) {
        this.ıd = ıd;
        this.name = name;
        this.date = date;
        this.description = null;
    }

    public Event() {
    }

    public long getId() {
        return ıd;
    }

    public void setId(long ıd) {
        this.ıd = ıd;
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
}


