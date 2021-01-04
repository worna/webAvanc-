package com.spring.henallux.CarPartsShop.dataAccess.dao;


import com.spring.henallux.CarPartsShop.model.Product;

import java.util.List;


public interface ProductDataAccess {
    Product findById (int id);
    List<Product> findAll ();
    List<Product> findBySalableTrue ();
    List<Product> findByCategoryEntity_CategoryId(Integer id);
}
