package com.solvd.bin;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Client {
    @JsonProperty
    private long id;
    @JsonProperty("fName")
    private String firstName;
    @JsonProperty("lName")
    private String lastName;
    @JsonProperty
    private Account account;
    @JsonProperty
    private double npi;
    @JsonProperty
    private String email;
    @JsonProperty
    private Appointment appointment;

    public Client() {
    }

    public Client(long id, String firstName, String lastName, Account account, double npi, String email, Appointment appointment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.npi = npi;
        this.email = email;
        this.appointment = appointment;
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
        return id == client.id && Double.compare(client.npi, npi) == 0 && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(account, client.account) && Objects.equals(email, client.email) && Objects.equals(appointment, client.appointment);
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
