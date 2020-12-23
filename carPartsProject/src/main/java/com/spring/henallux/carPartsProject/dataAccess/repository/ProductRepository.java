package com.spring.henallux.carPartsProject.dataAccess.repository;

import com.spring.henallux.carPartsProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.carPartsProject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,String>{
    ProductEntity findById(Integer id);
    List<ProductEntity> findAll();
    List<ProductEntity> findBySalableTrue();
    List<ProductEntity> findByCategoryEntity_CategoryId(Integer id);
}

