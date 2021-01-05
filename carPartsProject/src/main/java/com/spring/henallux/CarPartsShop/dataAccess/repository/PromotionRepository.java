package com.spring.henallux.CarPartsShop.dataAccess.repository;

import com.spring.henallux.CarPartsShop.dataAccess.entity.CategoryEntity;
import com.spring.henallux.CarPartsShop.dataAccess.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity,String>{
    @Query(value = "select p from PromotionEntity p where p.start_date < ?1 and p.end_date > ?1", nativeQuery = true)
    public List<PromotionEntity> findTodayPromotions(Date today);

}

