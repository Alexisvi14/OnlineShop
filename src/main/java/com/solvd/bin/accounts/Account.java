package com.solvd.bin.accounts;

import java.util.List;
import java.util.Objects;

public class Account {
    private long id;
    private double balance;
    private double cbu;
    private List<Card> cards;
    private List<Credit> credits;
    private List<Debt> debts;
    private List<Discount> discounts;
    private List<Payment> payments;

    public Account() {
        this.id = id;
        this.balance = balance;
        this.cbu = cbu;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Debt> getDebts() {
        return debts;
    }

    public void setDebts(List<Debt> debts) {
        this.debts = debts;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCbu() {
        return cbu;
    }

    public void setCbu(double cbu) {
        this.cbu = cbu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Double.compare(account.balance, balance) == 0 && cards.equals(account.cards) && credits.equals(account.credits) && debts.equals(account.debts) && discounts.equals(account.discounts) && payments.equals(account.payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, cards, credits, debts, discounts, payments);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", cbu=" + cbu +
                ", cards=" + cards +
                ", credits=" + credits +
                ", debts=" + debts +
                ", discounts=" + discounts +
                ", payments=" + payments +
                '}';
    }
}
