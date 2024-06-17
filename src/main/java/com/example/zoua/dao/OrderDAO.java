package com.example.zoua.dao;

import com.example.zoua.entity.Order;

import java.util.List;

public interface OrderDAO {
    void addOrder(Order order);
    List<Order> getAllOrders();
    List<Order> getOrdersByDate(String date);
    void export();
}

