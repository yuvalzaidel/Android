package com.example.lesson2_passing_objects_between_activities;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class Dog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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

    @NonNull
    @Override
    public String toString() {
        return "waf waf my name is " + name + ", I am " + age + " years old";
    }
}
