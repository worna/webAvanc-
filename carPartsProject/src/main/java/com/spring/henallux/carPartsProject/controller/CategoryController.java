package com.spring.henallux.carPartsProject.controller;


import com.spring.henallux.carPartsProject.dataAccess.dao.CategoryTranslationDAO;
import com.spring.henallux.carPartsProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.carPartsProject.model.CategoryTranslation;
import com.spring.henallux.carPartsProject.model.Product;
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
        List<Product> productResult = productDAO.findByCategoryEntity_CategoryId(Integer.parseInt(id));
        model.addAttribute("CategoryName", categoryTranslation.getName());
        model.addAttribute("CategoryId", id);
        model.addAttribute("Products", productResult);
        model.addAttribute("title","Car parts - "+categoryTranslation.getName());
        return "integrated:category";
    }
    
}
