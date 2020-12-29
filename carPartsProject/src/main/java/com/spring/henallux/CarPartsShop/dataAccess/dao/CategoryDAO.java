package com.spring.henallux.CarPartsShop.dataAccess.dao;

import com.spring.henallux.CarPartsShop.dataAccess.entity.CategoryEntity;
import com.spring.henallux.CarPartsShop.dataAccess.repository.CategoryRepository;
import com.spring.henallux.CarPartsShop.dataAccess.util.ProviderConverter;
import com.spring.henallux.CarPartsShop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess {
    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter providerConverter) {
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }
    public List<Category> findAll(){
        List<Category> categories = new ArrayList<Category>();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        for(int i = 0; i < categoryEntities.size(); i++){
            categories.add(providerConverter.categoryEntityToCategoryModel(categoryEntities.get(i)));
        }
        return categories;
    }
}
