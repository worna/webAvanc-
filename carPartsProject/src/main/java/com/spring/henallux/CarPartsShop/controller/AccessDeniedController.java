package com.spring.henallux.CarPartsShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/accessDenied")
public class AccessDeniedController {

    @Autowired
    public AccessDeniedController() {
    }

    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title","Car parts shop");
        return "integrated:accessDenied";
    }
    
}
