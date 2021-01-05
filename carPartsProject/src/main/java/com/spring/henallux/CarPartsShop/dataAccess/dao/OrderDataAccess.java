package com.spring.henallux.CarPartsShop.dataAccess.dao;


import com.spring.henallux.CarPartsShop.model.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface OrderDataAccess {
    Order findById(int id);
    List<Order> findByUser (HttpServletRequest request);

    void updateDate(Order order);

}
