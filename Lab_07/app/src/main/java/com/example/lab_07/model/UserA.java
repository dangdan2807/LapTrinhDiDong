package com.example.lab_07.model;

public class UserA {
    private int id;
    private String name;

    public UserA(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserA(String name) {
        this.name = name;
    }

    public UserA(int id) {
        this.id = id;
    }

    public UserA() {
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
