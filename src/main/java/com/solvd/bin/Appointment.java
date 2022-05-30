package com.solvd.bin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;


public class Appointment {
    @JsonProperty
    private long id;
    @JsonProperty
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "mm/dd/yyyy")
    private Date date;
    @JsonProperty
    private Time time;

    public Appointment(long id, Date date, Time time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public Appointment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
