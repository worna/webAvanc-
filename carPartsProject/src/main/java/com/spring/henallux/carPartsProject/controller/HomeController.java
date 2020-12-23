package com.spring.henallux.carPartsProject.controller;

import com.spring.henallux.carPartsProject.AddUsers;
import com.spring.henallux.carPartsProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.carPartsProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.carPartsProject.model.Category;
import com.spring.henallux.carPartsProject.model.Product;
import com.spring.henallux.carPartsProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;

import java.util.List;


@Controller
@RequestMapping(value="/home")
public class HomeController {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    public HomeController() {
    }

    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model){
        List<Category> result = categoryDAO.findAll();
        model.addAttribute("Categories", result);
        model.addAttribute("title","Car parts");
        return "integrated:home";
    }
    
}
