package com.spring.henallux.CarPartsShop.dataAccess.dao;


import com.spring.henallux.CarPartsShop.model.Order;

import java.util.List;


public interface OrderDataAccess {
    Order findById(int id);
}
