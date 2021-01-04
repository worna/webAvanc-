package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductDAO;
import com.spring.henallux.CarPartsShop.model.Product;
import com.spring.henallux.CarPartsShop.model.ProductInCart;
import com.spring.henallux.CarPartsShop.model.ProductToCart;
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

    private final ProductDAO productDAO;

    @Autowired
    public CartController(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @RequestMapping ( method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request) {
        HashMap<Product, Integer> products = ShoppingCart.getShoppingCart(request);

        model.addAttribute("title", "Car parts - Cart");
        model.addAttribute("productToCart", new ProductToCart());
        model.addAttribute("products", products);
        return "integrated:cart";
    }

    @RequestMapping (value="/modifyQuantity/{id}", method=RequestMethod.POST)
    public String modifyQuantity(HttpServletRequest request, @PathVariable String id, @ModelAttribute ProductToCart productToCart){
        Product result = productDAO.findById(Integer.parseInt(id));
        if(result == null)
            return "redirect:/404";

        if(result.getQuantityLeft() >= productToCart.getQuantity() && productToCart.getQuantity() >= 0) {
            int quantity = productToCart.getQuantity();
            ShoppingCart.updateProduct(result, quantity, request);
        }

        return "redirect:/cart";

    }
    
}
