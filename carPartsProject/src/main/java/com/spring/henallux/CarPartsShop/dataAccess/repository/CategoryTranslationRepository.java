package com.spring.henallux.carPartsProject.dataAccess.repository;

import com.spring.henallux.carPartsProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.carPartsProject.dataAccess.entity.CategoryTranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryTranslationRepository extends JpaRepository<CategoryTranslationEntity,String>{
    CategoryTranslationEntity findByCategoryIdAndLanguageName(Integer id, String language);
}

