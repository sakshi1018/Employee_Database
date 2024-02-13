package com.example.newapp.business;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Persist;

import java.util.List;

public class Person {
    @Property
    @Persist
    private int id;
    @Property
    @Persist
    private String name;
    @Property
    @Persist
    private int age;
    @Property
    private String username;
    @Property
    private String address;
    @Property
    private String password;


    public Person(int id,String username, String name, int age, String address,String password) {
        this.id=id;
        this.name = name;
        this.username = username;
        this.age = age;
        this.address=address;
        this.password=password;

    }
    public int getId(){
        return id;
    }
    public String getUserName(){
        return username;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAddress() {
        return address;
    }
    public String getPassword() {
        return password;
    }



}
