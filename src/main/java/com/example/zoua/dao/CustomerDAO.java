package com.example.zoua.dao;

import com.example.zoua.entity.Customer;

public interface CustomerDAO {
    void addCustomer(Customer customer);
    Customer getCustomerByPhoneNumber(String phoneNumber);
    void updateTotalPurchasedItems(int customerId, int itemsPurchased);
}

