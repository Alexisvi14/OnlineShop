package com.solvd.bin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class Provider {
    private final static Logger LOGGER = LogManager.getLogger(Provider.class);

    private Long id;
    private String firstName;
    private String lastName;
    private List<Truck>trucks;

    public Provider() {
    }

    public Provider(Long id, String firstName, String lastName, List<Truck> trucks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.trucks = trucks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return Objects.equals(id, provider.id) && Objects.equals(firstName, provider.firstName) && Objects.equals(lastName, provider.lastName) && Objects.equals(trucks, provider.trucks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, trucks);
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", trucks=" + trucks +
                '}';
    }
}
