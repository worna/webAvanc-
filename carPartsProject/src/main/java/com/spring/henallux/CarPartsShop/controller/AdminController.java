package com.spring.henallux.carPartsProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    public AdminController() {
    }

    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title","Admin");
        return "integrated:admin";
    }
    
}
