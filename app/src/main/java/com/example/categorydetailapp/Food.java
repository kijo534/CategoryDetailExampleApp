package com.example.categorydetailapp;

public class Food {
    private String name;
    private String desc;
    private double price;
    private int imageResourceID;

    //Constructor
    public Food(String name, String desc, double price, int imageResourceID) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.imageResourceID = imageResourceID;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }
}
