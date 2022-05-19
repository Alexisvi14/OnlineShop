package com.solvd.bin.shop;

import com.solvd.bin.staff.Provider;

import java.util.Objects;

public class Truck {
    private long id;
    private Provider provider;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return id == truck.id && provider.equals(truck.provider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, provider);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", provider=" + provider +
                '}';
    }
}
