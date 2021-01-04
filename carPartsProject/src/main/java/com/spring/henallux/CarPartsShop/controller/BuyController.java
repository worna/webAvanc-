package com.spring.henallux.CarPartsShop.controller;

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

    private ProductDAO productDAO;
    private boolean validCart;

    @Autowired
    public BuyController(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @RequestMapping ( method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request) {
        ArrayList<ProductInCart> products = new ArrayList<>();
        HashMap<Integer, Integer> productsInCart = ShoppingCart.getShoppingCart(request);
        validCart = true;
        productsInCart.forEach((product, quantity) -> {
            Product productModel = productDAO.findById(product);
            if(productModel.getQuantityLeft() < quantity)
                validCart = false;
        });
        if(validCart){
            productsInCart.forEach((product, quantity) -> {
                Product productModel = productDAO.findById(product);
                products.add(new ProductInCart(productModel.getName(), quantity, productModel.getPrice()));
                productDAO.updateProduct(product, quantity);
            });

            ShoppingCart.clearCart(request);
            model.addAttribute("title", "Car parts - Buy");
            model.addAttribute("products", products);
            return "integrated:buy";
        }else{
            return "redirect:/cart";
        }
    }
    
}
