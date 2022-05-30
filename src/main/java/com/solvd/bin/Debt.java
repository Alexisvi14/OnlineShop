package com.solvd.bin;

import java.util.Objects;

public class Debt {
    private long id;
    private double money;

    public Debt(long id, double money) {
        this.id = id;
        this.money = money;
    }

    public Debt() {
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
        Debt debt = (Debt) o;
        return id == debt.id && Double.compare(debt.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money);
    }

    @Override
    public String toString() {
        return "Debt{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
