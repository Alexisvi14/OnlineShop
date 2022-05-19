package com.solvd.bin.clientRelated;

import com.solvd.bin.accounts.Account;

import java.util.Objects;

public class Client {
    private long id;
    private String firstName;
    private String lastName;
    private Account account;
    private double npi;
    private String email;
    private Appointment appointment;

    public Client() {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.npi = npi;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Double.compare(client.npi, npi) == 0 && firstName.equals(client.firstName) && lastName.equals(client.lastName) && account.equals(client.account) && email.equals(client.email) && appointment.equals(client.appointment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, account, npi, email, appointment);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                ", npi=" + npi +
                ", email='" + email + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
