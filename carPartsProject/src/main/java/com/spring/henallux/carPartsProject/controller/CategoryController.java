package com.spring.henallux.carPartsProject.controller;

import com.spring.henallux.carPartsProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.carPartsProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.carPartsProject.model.Category;
import com.spring.henallux.carPartsProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping(value="/category/{id}")
public class CategoryController {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDAO productDAO;

    @RequestMapping ( method = RequestMethod.GET)
    public String home(Model model, @PathVariable String id){
        Category categoryResult = categoryDAO.findByCategoryId(Integer.parseInt(id));
        List<Product> productResult = productDAO.findByCategoryEntity_CategoryId(Integer.parseInt(id));
        model.addAttribute("Category", categoryResult);
        model.addAttribute("Products", productResult);
        model.addAttribute("title","Car parts - "+categoryResult.getName());
        return "integrated:category";
    }
    
}
