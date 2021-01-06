package com.spring.henallux.CarPartsShop.utils;

import com.spring.henallux.CarPartsShop.model.Order;
import com.spring.henallux.CarPartsShop.model.ProductOrder;
import com.spring.henallux.CarPartsShop.model.Promotion;

import java.util.*;

public class Utils {

    public static Promotion getBestPromotion(List<Promotion> promotions){
        if(promotions.size() == 0)
            return null;

        int maxPercent = 0;
        Promotion maxPromo = null;

        for(Promotion promotion : promotions){
            if(promotion.getPercent() > maxPercent){
                maxPercent = promotion.getPercent();
                maxPromo = promotion;
            }
        }

        return maxPromo;
    }
}



