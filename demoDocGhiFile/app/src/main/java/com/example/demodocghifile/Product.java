package com.example.demodocghifile;

public class Product {
    private String name;
    private double price;
    private String imageName;
    private String desc;

    public Product(String name, double price, String imageName, String desc) {
        this.name = name;
        this.price = price;
        this.imageName = imageName;
        this.desc = desc;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
