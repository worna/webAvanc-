package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/authenticated")
public class AuthenticatedController {
    @Autowired
    public AuthenticatedController() {
    }

    @RequestMapping ( method = RequestMethod.GET)
    public String authenticated (){
        return "integrated:authenticated";
    }


    
}
