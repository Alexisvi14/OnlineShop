package com.solvd.shop;

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
}
