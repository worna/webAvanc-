package com.spring.henallux.carPartsProject.controller;

import com.spring.henallux.carPartsProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.carPartsProject.model.Cart;
import com.spring.henallux.carPartsProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping(value="/product/{id}")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;


    @RequestMapping ( method = RequestMethod.GET)
    public String home(Model model, @PathVariable String id){
        Product result = productDAO.findById(Integer.parseInt(id));
        model.addAttribute("Quantity", new Cart());
        model.addAttribute("Product", result);
        model.addAttribute("title","Car parts - "+result.getName());
        return "integrated:product";
    }

}
