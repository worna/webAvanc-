package com.spring.henallux.CarPartsShop.model;

import java.util.HashMap;

public class Cart {
    private HashMap<Product, Integer> cartPrdouctsQuantities = new HashMap<Product, Integer> ();
    public Cart(){}

    public HashMap<Product, Integer> getCartPrdouctsQuantities() {
        return cartPrdouctsQuantities;
    }

    public void setCartPrdouctsQuantities(HashMap<Product, Integer> cartPrdouctsQuantities) {
        this.cartPrdouctsQuantities = cartPrdouctsQuantities;
    }
}
