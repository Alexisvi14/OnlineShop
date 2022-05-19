package com.solvd.bin.accounts;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return id == discount1.id && Objects.equals(discount, discount1.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discount);
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discount=" + discount +
                '}';
    }
}
