package com.doubleC.grape.business.find.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.doubleC.grape.business.find.json.bean.Child;
import com.doubleC.grape.business.find.json.bean.Dog;
import com.doubleC.grape.business.find.json.bean.Father;
import com.doubleC.grape.business.find.json.bean.Toy;

public class test {
    
    public static Father json2Obj(String json){
        Father father = new Father();
        try {
            JSONObject jsonObject = new JSONObject(json);
            int id = jsonObject.getInt("id");
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            JSONArray childArray = jsonObject.getJSONArray("childList");
            JSONArray dogArray = jsonObject.getJSONArray("dogList");
            int childArraySize = childArray.length();
            int dogArraySize = dogArray.length();
            
            List<Child> childList = new ArrayList<Child>();
            for(int i=0;i<childArraySize;i++){
                Child child = new Child();
                JSONObject childJB = childArray.getJSONObject(i);
                
                int childId = childJB.getInt("id");
                String childName = childJB.getString("name");
                int childAge = childJB.getInt("age");
                JSONArray toyArray = childJB.getJSONArray("toyList");
                child.setId(childId);
                child.setName(childName);
                child.setAge(childAge);
                
                List<Toy> toyList = new ArrayList<Toy>();
                int toySize = toyArray.length();
                for(int j=0;j<toySize;j++){
                    Toy toy = new Toy();
                    JSONObject toyJB = toyArray.getJSONObject(j);
                    int toyId = toyJB.getInt("id");
                    double toyPrice = toyJB.getDouble("price");
                    toy.setId(toyId);
                    toy.setPrice(toyPrice);
                }
            }
            
            
            
            
            
            
            
            father.setId(id);
            father.setName(name);
            father.setAge(age);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return father;
    }
    
    //father对象转变为json
    public static String obj2Json(){
        Father father = new Father(1, "刘翔", 29);
        List<Child> childList = new ArrayList<Child>();
        Child child1 = new Child(1,"小明",2);
        Child child2 = new Child(2,"小芳",1);
        
        //家里面有两只小狗
        List<Dog> dogList = new ArrayList<Dog>();
        for(int i = 0;i<2;i++){
            Dog dog = new Dog(i,"小狗  "+i);
            dogList.add(dog);
        }
        father.setDogList(dogList);
        
        //小明的玩具
        List<Toy> xiaomingToysList = new ArrayList<Toy>();
        for(int i=0;i<5;i++){
            Toy toy = new Toy(i,(i+1)*10);
            xiaomingToysList.add(toy);
        }
        child1.setToyList(xiaomingToysList);
        
        //小芳的玩具
        List<Toy> xiaofangToyList = new ArrayList<Toy>();
        for(int i=0;i<4;i++){
            Toy toy = new Toy(i,(i+1)*10);
            xiaofangToyList.add(toy);
        }
        child2.setToyList(xiaofangToyList);
        
        //父亲的孩子
        childList.add(child1);
        childList.add(child2);
        father.setChildList(childList);
        
        String fatherJson = JSON.toJSONString(father);
        return fatherJson;
    }
}
