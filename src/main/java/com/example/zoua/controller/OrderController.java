package com.example.zoua.controller;

import com.example.zoua.entity.Order;
import com.example.zoua.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDAO dao;


    @PostMapping("/add")
    public void addOrder(@RequestBody Order order) {
        dao.addOrder(order);
    }

    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        
        return dao.getAllOrders();
    }

    @GetMapping("/getByDate/{date}")
    public List<Order> getOrdersByDate(@PathVariable String date) {
        return dao.getOrdersByDate(date);
    }

    @GetMapping("/getCSVFile")
    public void getCSVFile() {
        // System.out.println("HI");
        dao.export();
    }
}


