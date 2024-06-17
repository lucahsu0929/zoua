package com.example.zoua.dao;

import com.example.zoua.dao.CustomerDAO;
import com.example.zoua.entity.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private final JdbcTemplate jdbcTemplate;

    public CustomerDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (phoneNumber, totalPurchasedItems) VALUES (?, ?)";
        jdbcTemplate.update(sql, customer.getPhoneNumber(), customer.getTotalPurchasedItems());
    }

    @Override
    public Customer getCustomerByPhoneNumber(String phoneNumber) {
        String sql = "SELECT * FROM Customer WHERE phoneNumber = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{phoneNumber}, new CustomerRowMapper());
    }

    @Override
    public void updateTotalPurchasedItems(int customerId, int itemsPurchased) {
        String sql = "UPDATE Customer SET totalPurchasedItems = totalPurchasedItems + ? WHERE id = ?";
        jdbcTemplate.update(sql, itemsPurchased, customerId);
    }

    private static class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setPhoneNumber(rs.getString("phoneNumber"));
            customer.setTotalPurchasedItems(rs.getInt("totalPurchasedItems"));
            return customer;
        }
    }
}

