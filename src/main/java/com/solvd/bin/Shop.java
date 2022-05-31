package com.solvd.bin;

import java.util.Objects;

public class Shop {
    private long id;
    private String name;
    private String webPage;
    private int phoneNumber;

    public Shop(long id, String name, String webPage, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.webPage = webPage;
        this.phoneNumber = phoneNumber;
    }

    public Shop() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id == shop.id && phoneNumber == shop.phoneNumber && Objects.equals(name, shop.name) && Objects.equals(webPage, shop.webPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, webPage, phoneNumber);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", webPage='" + webPage + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
