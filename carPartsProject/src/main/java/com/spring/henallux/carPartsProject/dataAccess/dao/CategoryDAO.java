package com.spring.henallux.carPartsProject.dataAccess.dao;

import com.spring.henallux.carPartsProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.carPartsProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.carPartsProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.carPartsProject.model.Category;
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

    public Category findByCategoryId (int id){
        CategoryEntity categoryEntity = categoryRepository.findByCategoryId(id);
        Category category = providerConverter.categoryEntityToCategoryModel(categoryEntity);
        return category;
    }
    public List<Category> findByOrderByName(){
        List<Category> categories = new ArrayList<Category>();
        List<CategoryEntity> categoryEntities = categoryRepository.findByOrderByName();
        for(int i = 0; i < categoryEntities.size(); i++){
            categories.add(providerConverter.categoryEntityToCategoryModel(categoryEntities.get(i)));
        }
        return categories;
    }
}
