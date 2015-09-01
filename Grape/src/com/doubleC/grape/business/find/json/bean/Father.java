package com.doubleC.grape.business.find.json.bean;

import java.util.List;

public class Father {
    private int id;
    private String name;
    private int age;
    private List<Child> childList;  //孩子的集合
    private List<Dog> dogList;      //狗狗集合
    public Father() {
    }
    public Father(int id, String name, int age) {
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

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public void setDogList(List<Dog> dogList) {
        this.dogList = dogList;
    }
    
}
