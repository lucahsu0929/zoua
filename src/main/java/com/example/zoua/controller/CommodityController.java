package com.example.zoua.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.example.zoua.dao.CommodityDAO;
import com.example.zoua.entity.Commodity;


@RestController
@CrossOrigin
public class CommodityController{
    @Autowired
    CommodityDAO dao;

    
    // private ArrayList<Commodity> commodityList = new ArrayList<>(); 

    // public CommodityController(){
    //     commodityList.add(new Commodity(5L, "Luca","Miaoli",20));
    // }

    @GetMapping("/commodity/getAll")
    public List<Commodity> retrievecommoditys() throws Exception{
        return dao.findAll();
        // return commodityList;
    }

    @PostMapping("/commodity/add")
    public void processFormCreate(@RequestBody Commodity commodity) throws SQLException{
        dao.insert(commodity);
    }


    @GetMapping("/commodity/get/{id}")
    public Commodity retrieveOnecommodity(@PathVariable("id") Long id) throws SQLException{
        return dao.findOne(id);
    }

    @PutMapping("/commodity/modify")
    public int processFormUpdate(@RequestBody Commodity commodity) throws SQLException{
        return dao.update(commodity);
    }

    @DeleteMapping("/commodity/delete/{id}")
    public int processFormDelete(@PathVariable("id") Long id) throws SQLException{
        return dao.delete(id);
    }

   



}


