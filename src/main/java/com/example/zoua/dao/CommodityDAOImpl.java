package com.example.zoua.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.zoua.entity.Commodity;

@Repository
public class CommodityDAOImpl implements CommodityDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Commodity> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM commodity",
                (rs, rowNum) -> new Commodity(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("stock"),
                        rs.getInt("sales")));
    }

    @Override
    public Commodity findOne(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM commodity WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Commodity(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("stock"),
                        rs.getInt("sales")));
    }

    @Override
    public int insert(Commodity commodity) {
        System.out.println(commodity);
        return jdbcTemplate.update(
                "INSERT INTO commodity (name, description, genre, price, stock, sales) VALUES (?, ?, ?, ?, ?, ?)",
                commodity.getName(), commodity.getDescription(), commodity.getGenre(), commodity.getPrice(),
                commodity.getStock(), commodity.getSales());
    }

    @Override
    public int update(Commodity commodity) {
        String sql = "UPDATE commodity SET name = ?, description = ?, genre = ?, price = ?, stock = ?, sales = ? WHERE id = ?";
        return jdbcTemplate.update(sql, commodity.getName(), commodity.getDescription(), commodity.getGenre(),
                commodity.getPrice(), commodity.getStock(), commodity.getSales(), commodity.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM commodity WHERE id = ?", id);
    }
}

