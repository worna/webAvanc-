package com.spring.henallux.CarPartsShop.model;

public class ProductInCart {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public ProductInCart(int id, String name, int quantity, double price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    public int getId() {
        return id;
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
