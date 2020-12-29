package com.spring.henallux.CarPartsShop.dataAccess.dao;


import com.spring.henallux.CarPartsShop.model.Category;
import com.spring.henallux.CarPartsShop.model.CategoryTranslation;

import java.util.List;


public interface CategoryTranslationDataAccess {
    CategoryTranslation findByCategoryIdAndLanguageName(Integer id, String language);
}
