package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.dataAccess.dao.CategoryTranslationDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductDAO;
import com.spring.henallux.CarPartsShop.model.*;
import com.spring.henallux.CarPartsShop.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(value="/product/{id}")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private CategoryTranslationDAO categoryTranslationDAO;


    @RequestMapping ( method = RequestMethod.GET)
    public String home(Model model, @PathVariable String id, Locale locale){
        int intId;
        try {
            intId = Integer.parseInt(id);
        } catch(NumberFormatException e){
            return "redirect:/404";
        }

        Product result = productDAO.findById(intId);
        if(result == null)
            return "redirect:/404";
        CategoryTranslation categoryTranslation = categoryTranslationDAO.findByCategoryIdAndLanguageName(result.getCategory().getCategoryId(),locale.getLanguage());
        model.addAttribute("Product", result);
        model.addAttribute("CategoryTranslation", categoryTranslation);
        model.addAttribute("title","Car parts shop");
        model.addAttribute("productToCart", new ProductToCart());
        return "integrated:product";
    }

    @RequestMapping(value="/addToCart", method=RequestMethod.POST)
    public String addProductToCart(HttpServletRequest request, @PathVariable String id, @ModelAttribute(value = "productToCart") ProductToCart productToCart) {
        Product result = productDAO.findById(Integer.parseInt(id));
        if(result == null)
            return "redirect:/404";

        if(result.getQuantityLeft() >= productToCart.getQuantity() && productToCart.getQuantity() > 0) {
            int quantity = productToCart.getQuantity();
            ShoppingCart.addProduct(result, quantity, request);
        }

        return "redirect:/product/" + id;
    }
}
