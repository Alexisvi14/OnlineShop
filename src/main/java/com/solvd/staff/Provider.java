package com.solvd.staff;

import com.solvd.shop.Truck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Provider extends Employee {
    private final static Logger LOGGER = LogManager.getLogger(Provider.class);
    private List<Truck>trucks;

    public Provider(long id, String firstName, String lastName, List<Truck> trucks) {
        super(id, firstName, lastName);
        this.trucks = trucks;
    }
    public Provider(long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public List<Truck> getTrucks() {
        return trucks;
    }
    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }
}
