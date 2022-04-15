package com.example.lap_06;

import java.io.Serializable;

public class Shoe implements Serializable {
    private String name;
    private String detail;
    private double price;
    private String shoeWidth;
    private String sole;
    private int image;
    private String closure;

    public Shoe(String name, String detail, double price, String shoeWidth, String sole, int image, String closure) {
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.shoeWidth = shoeWidth;
        this.sole = sole;
        this.image = image;
        this.closure = closure;
    }

    public Shoe(String name, String detail, int image) {
        this.name = name;
        this.detail = detail;
        this.price = 0;
        this.shoeWidth = "";
        this.sole = "";
        this.image = image;
        this.closure = "";
    }

    public Shoe() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShoeWidth() {
        return shoeWidth;
    }

    public void setShoeWidth(String shoeWidth) {
        this.shoeWidth = shoeWidth;
    }

    public String getSole() {
        return sole;
    }

    public void setSole(String sole) {
        this.sole = sole;
    }

    public String getClosure() {
        return closure;
    }

    public void setClosure(String closure) {
        this.closure = closure;
    }
}
