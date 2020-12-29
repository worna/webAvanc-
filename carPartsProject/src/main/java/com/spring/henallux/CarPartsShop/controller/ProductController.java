package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.dataAccess.dao.CategoryTranslationDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductDAO;
import com.spring.henallux.CarPartsShop.model.Cart;
import com.spring.henallux.CarPartsShop.model.CategoryTranslation;
import com.spring.henallux.CarPartsShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        Product result = productDAO.findById(Integer.parseInt(id));
        CategoryTranslation categoryTranslation = categoryTranslationDAO.findByCategoryIdAndLanguageName(result.getCategory().getCategoryId(),locale.getLanguage());
        model.addAttribute("Quantity", new Cart());
        model.addAttribute("Product", result);
        model.addAttribute("CategoryTranslation", categoryTranslation);
        model.addAttribute("title","Car parts - "+result.getName());
        return "integrated:product";
    }

}
