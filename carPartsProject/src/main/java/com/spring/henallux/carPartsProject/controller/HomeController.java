package com.spring.henallux.carPartsProject.controller;

import com.spring.henallux.carPartsProject.AddUsers;
import com.spring.henallux.carPartsProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.carPartsProject.dataAccess.dao.CategoryTranslationDAO;
import com.spring.henallux.carPartsProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.carPartsProject.model.Category;
import com.spring.henallux.carPartsProject.model.CategoryTranslation;
import com.spring.henallux.carPartsProject.model.Product;
import com.spring.henallux.carPartsProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(value="/home")
public class HomeController {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private CategoryTranslationDAO categoryTranslationDAO;
    @Autowired
    public HomeController() {
    }

    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model, Locale locale){
        List<Category> categories = categoryDAO.findAll();
        List<CategoryTranslation> categoriesNames = new ArrayList<>();
        for(int i = 0; i < categories.size(); i++){
            categoriesNames.add(categoryTranslationDAO.findByCategoryIdAndLanguageName(categories.get(i).getCategoryId(),locale.getLanguage()));
        }
        model.addAttribute("Categories", categories);
        model.addAttribute("CategoriesNames", categoriesNames);
        model.addAttribute("title","Car parts");
        return "integrated:home";
    }
    
}
