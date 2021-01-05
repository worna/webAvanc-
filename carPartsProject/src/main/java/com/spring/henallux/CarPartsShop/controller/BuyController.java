package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.dataAccess.dao.OrderDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductDAO;
import com.spring.henallux.CarPartsShop.model.Product;
import com.spring.henallux.CarPartsShop.model.ProductInCart;
import com.spring.henallux.CarPartsShop.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping(value = "/buy")
@SessionAttributes({Constants.SESSION_CART})
public class BuyController {

    private OrderDAO orderDAO;
    private ProductDAO productDAO;
    private boolean validCart;

    @Autowired
    public BuyController(ProductDAO productDAO, OrderDAO orderDAO){
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request) {
        HashMap<Product, Integer> productsInCart = ShoppingCart.getShoppingCart(request);
        if(productsInCart.size() == 0)
            return "redirect:/cart";

        validCart = true;
        productsInCart.forEach((product, quantity) -> {
            if(product.getQuantityLeft() < quantity)
                validCart = false;
        });
        if(validCart){
            productsInCart.forEach((product, quantity) -> {
                productDAO.updateProduct(product.getId(), quantity);
            });
            orderDAO.addOrder(productsInCart,request);
            ShoppingCart.clearCart(request);
            model.addAttribute("title", "Car parts - Buy");
            model.addAttribute("products", productsInCart);
            return "integrated:buy";
        } else {
            return "redirect:/cart";
        }
    }
}
