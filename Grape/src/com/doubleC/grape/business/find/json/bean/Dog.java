package com.doubleC.grape.business.find.json.bean;

public class Dog {
    private int id;
    private String name;
    public Dog() {
    }
    public Dog(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
