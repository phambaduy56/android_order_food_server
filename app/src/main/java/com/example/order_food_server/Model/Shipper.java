package com.example.order_food_server.Model;

public class Shipper {
    private String name, phone;

    public Shipper() {
    }

    public Shipper(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
