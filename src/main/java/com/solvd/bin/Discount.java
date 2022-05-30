package com.solvd.bin;

import java.util.Objects;

public class Discount {
    private long id;
    private int percentage;

    public Discount(long id, int percentage) {
        this.id = id;
        this.percentage = percentage;
    }

    public Discount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return id == discount.id && percentage == discount.percentage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, percentage);
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", percentage=" + percentage +
                '}';
    }
}
