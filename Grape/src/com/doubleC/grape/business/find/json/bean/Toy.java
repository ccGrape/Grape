package com.doubleC.grape.business.find.json.bean;


public class Toy {
    private int id;
    private double price;
    public Toy() {
    }
    public Toy(int id, double price) {
        super();
        this.id = id;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}
