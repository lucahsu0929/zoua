package com.example.zoua.dao;

import java.util.List;
import com.example.zoua.entity.Commodity;

public interface CommodityDAO{
    public List<Commodity> findAll();
    public Commodity findOne(Long id);
    public int insert(Commodity commodity);
    public int update(Commodity commodity);
    public int delete(Long id);
}
