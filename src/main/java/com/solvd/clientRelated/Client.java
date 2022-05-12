package com.solvd.clientRelated;

import com.solvd.accounts.Account;

public class Client {
    private long id;
    private String firstName;
    private String lastName;
    private Account account;
    private double npi;
    private String email;

    public Client(long id, String firstName, String lastName, Account account, double npi) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.npi = npi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getNpi() {
        return npi;
    }

    public void setNpi(double npi) {
        this.npi = npi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
