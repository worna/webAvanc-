package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductDAO;
import com.spring.henallux.CarPartsShop.model.Product;
import com.spring.henallux.CarPartsShop.model.ProductInCart;
import com.spring.henallux.CarPartsShop.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.SESSION_CART})
public class CartController {

    private ProductDAO productDAO;

    @Autowired
    public CartController(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @RequestMapping ( method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request) {
        ArrayList<ProductInCart> products = new ArrayList<>();
        HashMap<Integer, Integer> productsInCart = ShoppingCart.getShoppingCart(request);

        productsInCart.forEach((product, quantity) -> {
            Product productModel = productDAO.findById(product);
            products.add(new ProductInCart(productModel.getName(), quantity, productModel.getPrice() * quantity));
        });

        model.addAttribute("title", "Car parts - Cart");
        model.addAttribute("products", products);
        return "integrated:cart";
    }
    
}
