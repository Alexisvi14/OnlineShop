package com.solvd.bin.staff;

import com.solvd.bin.shop.Truck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class Provider extends Employee {
    private final static Logger LOGGER = LogManager.getLogger(Provider.class);
    private List<Truck>trucks;

    public Provider(long id, String firstName, String lastName, List<Truck> trucks) {
        super();
        this.trucks = trucks;
    }
    public Provider(long id, String firstName, String lastName) {
        super();
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
        if (!super.equals(o)) return false;
        Provider provider = (Provider) o;
        return trucks.equals(provider.trucks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trucks);
    }

    @Override
    public String toString() {
        return "Provider{" +
                "trucks=" + trucks +
                '}';
    }
}
