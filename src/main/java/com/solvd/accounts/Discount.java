package com.solvd.accounts;

public class Discount {
    private long id;
    private Discount discount;

    public Discount(long id, Discount discount) {
        this.id = id;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
