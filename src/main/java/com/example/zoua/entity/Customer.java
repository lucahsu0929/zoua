package com.example.zoua.entity;

public class Customer {
    private int id;
    private String phoneNumber;
    private int totalPurchasedItems;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTotalPurchasedItems() {
        return totalPurchasedItems;
    }

    public void setTotalPurchasedItems(int totalPurchasedItems) {
        this.totalPurchasedItems = totalPurchasedItems;
    }
}

