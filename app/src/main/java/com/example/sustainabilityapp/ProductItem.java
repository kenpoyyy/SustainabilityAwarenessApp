package com.example.sustainabilityapp;

public class ProductItem {

    private String name,brand,price;
    private int image;

    public ProductItem(String name, String brand, String price, int image) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.image = image;
    }

    public ProductItem(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
