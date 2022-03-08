package com.example.lab_04.model;

public class Product {
    private String productName;
    private String shopName;
    private String imageName;

    public Product() {
    }

    public Product(String productName, String shopName, String imageId) {
        this.productName = productName;
        this.shopName = shopName;
        this.imageName = imageId;
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
