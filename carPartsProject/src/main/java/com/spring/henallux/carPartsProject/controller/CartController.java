package com.spring.henallux.carPartsProject.controller;

import com.spring.henallux.carPartsProject.model.Cart;
import com.spring.henallux.carPartsProject.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.SESSION_CART})
public class CartController {

    @RequestMapping ( method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.SESSION_CART)Cart cart) {
        model.addAttribute("title", "Car parts - Cart");
        return "integrated:cart";
    }
    
}
