package com.spring.henallux.carPartsProject.controller;

import com.spring.henallux.carPartsProject.dataAccess.dao.UserDAO;
import com.spring.henallux.carPartsProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/register")
public class RegisterController {
    @Autowired
    private UserDAO userDAO;
    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title","CarParts - Register");
        model.addAttribute("userForm",new User());
        return "integrated:register";
    }
    @RequestMapping (value="/send", method = RequestMethod.POST)
    public String getFormData (Model model, @Valid @ModelAttribute(value = "userForm")User inscriptionForm, final BindingResult errors){
        if(!errors.hasErrors()){
            String welcomeMessage = "welcome," + inscriptionForm.getEmail()+"!";
            userDAO.addUser(inscriptionForm);
            System.out.println(welcomeMessage);
            return "redirect:/home";
        } else {
            System.out.println(errors.getModel());
            return "integrated:register";
        }
    }
    
}
