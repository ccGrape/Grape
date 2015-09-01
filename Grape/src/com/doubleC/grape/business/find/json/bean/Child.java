package com.doubleC.grape.business.find.json.bean;

import java.util.List;

public class Child {
    private int id;
    private String name;
    private int age;
    private List<Toy> toyList;
    
    public Child() {
    }
    
    public Child(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public List<Toy> getToyList() {
        return toyList;
    }
    public void setToyList(List<Toy> toyList) {
        this.toyList = toyList;
    }
}
