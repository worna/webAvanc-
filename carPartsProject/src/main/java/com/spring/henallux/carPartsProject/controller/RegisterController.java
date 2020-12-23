package com.spring.henallux.carPartsProject.controller;

import com.spring.henallux.carPartsProject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title","CarParts - Register");
        model.addAttribute("userForm",new User());
        return "integrated:register";
    }
    @RequestMapping (value="/send", method = RequestMethod.POST)
    public String getFormData (Model model, @ModelAttribute(value = "userForm")User inscriptionForm){
        String welcomeMessage = "welcome," + inscriptionForm.getEmail()+"!";
        System.out.println(welcomeMessage);
        return "integrated:home";
    }
    
}
