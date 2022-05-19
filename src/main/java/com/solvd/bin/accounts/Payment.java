package com.solvd.bin.accounts;

import java.util.Objects;

public class Payment {
    private long id;
    private double money;

    public Payment(long id, double money) {
        this.id = id;
        this.money = money;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && Double.compare(payment.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
