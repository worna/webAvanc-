package com.spring.henallux.carPartsProject.dataAccess.dao;



import com.spring.henallux.carPartsProject.model.Category;


import java.util.List;


public interface CategoryDataAccess {
    List<Category> findAll();
}