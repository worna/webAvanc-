package com.spring.henallux.CarPartsShop.model;

public class Product {
    private int id;
    private String name;
    private String brand;
    private double price;
    private int quantityLeft;
    private Boolean salable;
    private Category category;
    private String image;

    private String description;


    public Product(int id, String name, String brand, double price, int quantityLeft, Boolean salable, String description, Category category, String image) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantityLeft = quantityLeft;
        this.salable = salable;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public Product() {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public Boolean getSalable() {
        return salable;
    }

    public void setSalable(Boolean salable) {
        this.salable = salable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
