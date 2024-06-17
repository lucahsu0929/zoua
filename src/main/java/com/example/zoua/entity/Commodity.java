package com.example.zoua.entity;

public class Commodity {

    private Long id; 
    private String name; 
    private String description; 
    private String genre;
    private int price;
    private int stock;
    private int sales;

    public Commodity(){
        
    }

    public Commodity(Long id, String name, String description, String genre, int price, int stock, int sales){
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description= description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int getSales(){
        return sales;
    }

    public void setSales(int sales){
        this.sales = sales;
    }

    public String toString(){
        return "id : "+getId()+", "+"name : "+getName() + ", " + "description : " + getDescription() + ", " + "genre : " + getGenre() + ", " + "price : " + getPrice() + ", " + "stock : " + getStock() + ", " + "sales : " + getSales();
    }
}
