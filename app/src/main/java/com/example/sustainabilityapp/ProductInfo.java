package com.example.sustainabilityapp;

public class ProductInfo {

    String productName1,price,brand,description1,description2,productName2,price2,reviews,button1,button2;
    int image1,image2,rating;

    public ProductInfo(String productName1, String price, String brand, String description1, String description2, String productName2, String price2, String reviews, String button1, String button2, int image1, int image2, int rating) {
        this.productName1 = productName1;
        this.price = price;
        this.brand = brand;
        this.description1 = description1;
        this.description2 = description2;
        this.productName2 = productName2;
        this.price2 = price2;
        this.reviews = reviews;
        this.button1 = button1;
        this.button2 = button2;
        this.image1 = image1;
        this.image2 = image2;
        this.rating = rating;
    }

    public String getProductName1() {
        return productName1;
    }

    public void setProductName1(String productName1) {
        this.productName1 = productName1;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getProductName2() {
        return productName2;
    }

    public void setProductName2(String productName2) {
        this.productName2 = productName2;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getButton1() {
        return button1;
    }

    public void setButton1(String button1) {
        this.button1 = button1;
    }

    public String getButton2() {
        return button2;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
