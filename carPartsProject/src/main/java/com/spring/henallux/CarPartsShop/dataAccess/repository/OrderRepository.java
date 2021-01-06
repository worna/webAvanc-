package com.spring.henallux.CarPartsShop.dataAccess.repository;

import com.spring.henallux.CarPartsShop.dataAccess.entity.OrderEntity;
import com.spring.henallux.CarPartsShop.dataAccess.entity.ProductEntity;
import com.spring.henallux.CarPartsShop.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,String>{
    OrderEntity findById(Integer id);
    List<OrderEntity> findAllByUserEntityOrderByIdDesc(UserEntity user);
}

