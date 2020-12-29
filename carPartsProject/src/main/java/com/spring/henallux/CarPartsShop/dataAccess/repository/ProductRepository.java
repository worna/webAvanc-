package com.spring.henallux.CarPartsShop.dataAccess.repository;

import com.spring.henallux.CarPartsShop.dataAccess.entity.ProductEntity;
import com.spring.henallux.CarPartsShop.dataAccess.entity.UserEntity;
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

