package com.solvd.bin;

import java.util.Objects;

public class Payment {
    private long id;
    private double money;
    private String place;

    public Payment(long id, double money, String place) {
        this.id = id;
        this.money = money;
        this.place = place;
    }

    public Payment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && Double.compare(payment.money, money) == 0 && Objects.equals(place, payment.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money, place);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", money=" + money +
                ", place='" + place + '\'' +
                '}';
    }
}
