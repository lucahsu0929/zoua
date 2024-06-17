package com.example.zoua.dao;

import com.example.zoua.entity.Order;
import com.example.zoua.entity.Commodity;
import com.example.zoua.dao.CommodityDAOImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;




@Repository
public class OrderDAOImpl implements OrderDAO {
    private final JdbcTemplate jdbcTemplate;
    CommodityDAOImpl dao = new CommodityDAOImpl();

    public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addOrder(Order order) {
        String sql = "INSERT INTO FoodOrder (orderTime, productName, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, order.getOrderTime(), order.getProductName(), order.getPrice());
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM FoodOrder";
        List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper());
        return orders;
    }

    @Override
    public void export() {
        String sql = "SELECT * FROM FoodOrder";
        List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper());
        String data = "";
        String data2= "";

        for(Order order : orders){
            if(order.getPrice()==0){
                continue;
            }
            //productName 是指訂單列表
            String[] nameQuantity = order.getProductName().split("\n"); 

            String time = order.getOrderTime().toString();
            time = time.substring(0,time.indexOf(' ')).replaceAll("-","/");

            for(String cur : nameQuantity){
                // System.out.println("現在處理" + cur);
                // if(cur.trim().isEmpty()){
                //     continue;
                // }

                String[] temp = cur.split(" ");
                String name = temp[0];
                String quantity = temp[1];
                // System.out.println("陳阿共度:" + temp.length);
                // for(int i=0;i<temp.length;i++){
                    // System.out.println(temp[i]);
                // }
                // System.out.println(cur); 
                Commodity commodity = this.jdbcTemplate.queryForObject("select * from commodity where name = ?",
                new Object[]{name}, (rs, rowNum) -> new Commodity(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("genre"),
                    rs.getInt("price"),
                    rs.getInt("stock"),
                    rs.getInt("sales")
                    )
                );



                data += time + "," + name + "," 
                    + commodity.getPrice() + "," + quantity + "," + commodity.getGenre() + "," + order.getId() + "\n"; 

               
                // System.out.println(quantity);
            }

            data2 += time + "," + order.getId() + "," + order.getPrice() + "\n";

        }
                String info1 = "日期,品項,單品銷售額,數量,分類,訂單編號\n";
                data = info1 + data;

                String info2 = "日期,訂單編號,訂單總額\n";
                data2 = info2 + data2;


                    try (Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data1.csv"), "UTF-8"))) {
                        w.write(data);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                    try (Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data2.csv"), "UTF-8"))) {
                        w.write(data2);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }



                System.out.println(data);
                System.out.println(data2);
    }



    @Override
    public List<Order> getOrdersByDate(String date) {
        String sql = "SELECT * FROM FoodOrder WHERE DATE(orderTime) = ?";

        return jdbcTemplate.query(sql, new Object[]{date},  new OrderRowMapper());
    }

    private static class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setOrderTime(rs.getTimestamp("orderTime"));
            order.setProductName(rs.getString("productName"));
            order.setPrice(rs.getInt("price"));
            return order;
        }
    }
}

