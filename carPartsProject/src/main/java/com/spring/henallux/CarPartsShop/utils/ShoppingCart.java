package com.spring.henallux.CarPartsShop.utils;

import com.spring.henallux.CarPartsShop.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ShoppingCart {

    public static HashMap<Product, Integer> getShoppingCart(HttpServletRequest request){
        HashMap<Product, Integer> shoppingCart = (HashMap<Product, Integer>) request.getSession().getAttribute("shoppingCart");
        if(shoppingCart == null)
            shoppingCart = new HashMap<>();

        return shoppingCart;
    }

    public static void addProduct(Product product, int quantity, HttpServletRequest request){
        HashMap<Product, Integer> shoppingCart = getShoppingCart(request);

        AtomicInteger quantityFound = new AtomicInteger();
        AtomicReference<Product> productFound = new AtomicReference<>();
        shoppingCart.forEach((productSC, quantitySC) -> {
            if(productSC.getId() == product.getId()){
                quantityFound.set(quantitySC);
                productFound.set(productSC);
            }
        });

        if(productFound.get() != null)
            shoppingCart.remove(productFound.get());
        shoppingCart.put(product, quantity + quantityFound.get());

        request.getSession().setAttribute("shoppingCart", shoppingCart);

    }

    public static void updateProduct(Product product, int quantity, HttpServletRequest request){
        HashMap<Product, Integer> shoppingCart = getShoppingCart(request);

        AtomicReference<Product> productFound = new AtomicReference<>();
        shoppingCart.forEach((productSC, quantitySC) -> {
            if(productSC.getId() == product.getId()){
                productFound.set(productSC);
            }
        });

        if(productFound.get() == null) return;

        shoppingCart.remove(productFound.get());

        if(quantity > 0) {
            shoppingCart.put(product, quantity);
        }

        request.getSession().setAttribute("shoppingCart", shoppingCart);
    }

    public static void clearCart( HttpServletRequest request){
        request.getSession().setAttribute("shoppingCart", new HashMap<>());

    }
}
