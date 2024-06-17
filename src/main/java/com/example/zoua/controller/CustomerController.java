package com.example.zoua.controller;

import com.example.zoua.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoua.dao.CustomerDAO;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO dao;

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        dao.addCustomer(customer);
    }

    @GetMapping("/getByPhoneNumber/{phoneNumber}")
    public Customer getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
        return dao.getCustomerByPhoneNumber(phoneNumber);
    }

    @PutMapping("/updateTotalPurchasedItems/{customerId}/{itemsPurchased}")
    public void updateTotalPurchasedItems(@PathVariable int customerId, @PathVariable int itemsPurchased) {
        dao.updateTotalPurchasedItems(customerId, itemsPurchased);
    }
}

