package com.spring.henallux.CarPartsShop.dataAccess.dao;


import com.spring.henallux.CarPartsShop.model.Promotion;

import java.util.List;

public interface PromotionDataAccess {
    List<Promotion> findTodaysPromotions();
}
