package com.solvd.clientRelated;

import java.time.LocalDate;
import java.time.LocalTime;


public class Appointment {
    private long id;
    private LocalDate date;
    private LocalTime time;

    public Appointment(long id, LocalDate date, LocalTime time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
