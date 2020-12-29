package com.spring.henallux.carPartsProject.dataAccess.dao;


import com.spring.henallux.carPartsProject.model.Category;
import com.spring.henallux.carPartsProject.model.CategoryTranslation;

import java.util.List;


public interface CategoryTranslationDataAccess {
    CategoryTranslation findByCategoryIdAndLanguageName(Integer id, String language);
}
