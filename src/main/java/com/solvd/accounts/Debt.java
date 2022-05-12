package com.solvd.accounts;

public class Debt {
    private long id;
    private double money;

    public Debt(long id, double money) {
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
}
