package com.spring.henallux.CarPartsShop.dataAccess.dao;



import com.spring.henallux.CarPartsShop.model.Category;


import java.util.List;


public interface CategoryDataAccess {
    List<Category> findAll();
}
