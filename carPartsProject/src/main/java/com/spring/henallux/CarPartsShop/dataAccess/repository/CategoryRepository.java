package com.spring.henallux.carPartsProject.dataAccess.repository;

import com.spring.henallux.carPartsProject.dataAccess.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,String>{
    List<CategoryEntity> findAll();
}

