package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model, Authentication auth){
        if(auth == null) {
            model.addAttribute("title", "Login");
            model.addAttribute("userDetails", new User());
            return "integrated:login";
        } else {
            return "redirect:/";
        }
    }
    
}
