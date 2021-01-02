package com.spring.henallux.CarPartsShop.model;

public class ProductInCart {
    private String name;
    private int quantity;
    private double price;

    public ProductInCart(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
