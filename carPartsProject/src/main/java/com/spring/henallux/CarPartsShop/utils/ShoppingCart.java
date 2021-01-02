package com.spring.henallux.CarPartsShop.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ShoppingCart {

    public static HashMap<Integer, Integer> getShoppingCart(HttpServletRequest request){
        HashMap<Integer, Integer> shoppingCart = (HashMap<Integer, Integer>) request.getSession().getAttribute("shoppingCart");
        if(shoppingCart == null)
            shoppingCart = new HashMap<>();

        return shoppingCart;
    }

    public static void addProduct(int product, int quantity, HttpServletRequest request){
        HashMap<Integer, Integer> shoppingCart = getShoppingCart(request);

        if(shoppingCart.containsKey(product))
            shoppingCart.replace(product, shoppingCart.get(product) + quantity);
        else
            shoppingCart.put(product, quantity);

        request.getSession().setAttribute("shoppingCart", shoppingCart);

    }
}
