package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.dataAccess.dao.CategoryDAO;
import com.spring.henallux.CarPartsShop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping(value = "home/connected")
public class ConnectedController {
    @Autowired
    private CategoryDAO categoryDAO;
    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model){
        List<Category> result = categoryDAO.findAll();
        model.addAttribute("Categories", result);
        model.addAttribute("title","Car parts");
        return "integrated:home";
    }
    
}
