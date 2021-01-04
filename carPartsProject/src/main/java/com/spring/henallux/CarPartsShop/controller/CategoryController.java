package com.spring.henallux.CarPartsShop.controller;


import com.spring.henallux.CarPartsShop.dataAccess.dao.CategoryTranslationDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductDAO;
import com.spring.henallux.CarPartsShop.model.CategoryTranslation;
import com.spring.henallux.CarPartsShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(value="/category/{id}")
public class CategoryController {
    @Autowired
    private CategoryTranslationDAO categoryTranslationDAO;
    @Autowired
    private ProductDAO productDAO;

    @RequestMapping ( method = RequestMethod.GET)
    public String home(Model model, @PathVariable String id, Locale locale){
        CategoryTranslation categoryTranslation = categoryTranslationDAO.findByCategoryIdAndLanguageName(Integer.parseInt(id),locale.getLanguage());
        if(categoryTranslation == null)
            return "redirect:/404";

        List<Product> productResult = productDAO.findByCategoryEntity_CategoryId(Integer.parseInt(id));
        model.addAttribute("CategoryName", categoryTranslation.getName());
        model.addAttribute("CategoryId", id);
        model.addAttribute("Products", productResult);
        model.addAttribute("title","Car parts - "+categoryTranslation.getName());
        return "integrated:category";
    }
    
}
