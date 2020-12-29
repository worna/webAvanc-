package com.spring.henallux.CarPartsShop.dataAccess.dao;

import com.spring.henallux.CarPartsShop.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.CarPartsShop.dataAccess.repository.CategoryTranslationRepository;
import com.spring.henallux.CarPartsShop.dataAccess.util.ProviderConverter;
import com.spring.henallux.CarPartsShop.model.CategoryTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class CategoryTranslationDAO implements CategoryTranslationDataAccess {
    private CategoryTranslationRepository categoryTranslationRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryTranslationDAO(CategoryTranslationRepository categoryTranslationRepository, ProviderConverter providerConverter) {
        this.categoryTranslationRepository = categoryTranslationRepository;
        this.providerConverter = providerConverter;
    }

    public CategoryTranslation findByCategoryIdAndLanguageName (Integer id, String language){
        CategoryTranslationEntity categoryTranslationEntity = categoryTranslationRepository.findByCategoryIdAndLanguageName(id, language);
        CategoryTranslation categoryTranslation = providerConverter.categoryTranslationEntityToCategoryTranslationModel(categoryTranslationEntity);
        return categoryTranslation;
    }
}
