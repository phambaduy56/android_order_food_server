package com.example.order_food_server.Model;

public class Date {
    private int total;
    private String date;

    public Date(int total, String date) {
        this.total = total;
        this.date = date;
    }

    public Date() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
