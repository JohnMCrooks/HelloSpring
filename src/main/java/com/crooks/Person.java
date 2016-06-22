/*
 * Copyright (c) 2016.
 */

package com.crooks;

/**
 * Created by johncrooks on 6/20/16.
 */
public class Person {
    String name;
    String city;
    Integer age;

    public Person(String name, String city, Integer age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public Person() {
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

}
