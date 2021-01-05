package com.spring.henallux.CarPartsShop.dataAccess.dao;


import com.spring.henallux.CarPartsShop.model.ProductOrder;


public interface ProductOrderDataAccess {
    ProductOrder findById(int id);
}
