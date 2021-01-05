package com.spring.henallux.CarPartsShop.dataAccess.repository;

import com.spring.henallux.CarPartsShop.dataAccess.entity.CategoryEntity;
import com.spring.henallux.CarPartsShop.dataAccess.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity,String>{
    @Query("SELECT p FROM PromotionEntity p WHERE p.start_date < GETDATE() and p.end_date > GETDATE()")
    List<PromotionEntity> findTodaysPromotions();

}

