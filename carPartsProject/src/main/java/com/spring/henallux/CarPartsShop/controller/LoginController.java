package com.spring.henallux.carPartsProject.controller;

import com.spring.henallux.carPartsProject.configuration.WebSecurityConfiguration;
import com.spring.henallux.carPartsProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title","Login");
        model.addAttribute("userDetails",new User());
        return "integrated:login";
    }
    
}
