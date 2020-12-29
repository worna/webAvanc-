package com.spring.henallux.carPartsProject.dataAccess.dao;


import com.spring.henallux.carPartsProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.carPartsProject.model.Product;

import java.util.List;


public interface ProductDataAccess {
    Product findById (int id);
    List<Product> findAll ();
    List<Product> findBySalableTrue ();
    List<Product> findByCategoryEntity_CategoryId(Integer id);
}
