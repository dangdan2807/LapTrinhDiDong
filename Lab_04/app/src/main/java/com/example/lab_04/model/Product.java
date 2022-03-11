package com.example.lab_04.model;

public class Product {
    private String productName;
    private String shopName;
    private String imageName;
    private double rating;
    private double discount;
    private int vote;
    private double price;

    public Product() {
    }

    public Product(String productName, String shopName, String imageId) {
        this.productName = productName;
        this.shopName = shopName;
        this.imageName = imageId;
    }

    public Product(String productName, String imageName, double rating, double discount, int vote, double price) {
        this.productName = productName;
        this.imageName = imageName;
        this.rating = rating;
        this.discount = discount;
        this.vote = vote;
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", shopName='" + shopName + '\'' +
                ", imageId=" + imageName +
                '}';
    }
}
