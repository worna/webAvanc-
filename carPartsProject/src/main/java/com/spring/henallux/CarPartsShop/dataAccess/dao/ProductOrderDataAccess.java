package com.spring.henallux.CarPartsShop.dataAccess.dao;


import com.spring.henallux.CarPartsShop.dataAccess.entity.ProductOrderEntity;
import com.spring.henallux.CarPartsShop.model.ProductOrder;

import java.util.ArrayList;


public interface ProductOrderDataAccess {
    ProductOrder findById(int id);
    ArrayList<ProductOrder> findByOrderId(Integer orderId);
}
