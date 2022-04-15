package com.example.lab_07.model;

public class PlaceA {
    private int id;
    private String name;

    public PlaceA(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlaceA(int id) {
        this.id = id;
    }

    public PlaceA(String name) {
        this.name = name;
    }

    public PlaceA() {
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
