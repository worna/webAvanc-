package com.spring.henallux.CarPartsShop.model;

import javax.validation.constraints.Min;

public class ProductToCart {

    @Min(value = 1)
    int quantity;

    public ProductToCart(){
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
