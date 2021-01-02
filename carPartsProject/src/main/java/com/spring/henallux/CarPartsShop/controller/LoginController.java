package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping ( method = RequestMethod.GET)
    public String home (Model model, Authentication auth, @RequestParam(value = "error", required = false) String error){
        if(auth == null) {
            model.addAttribute("title", "Login");
            model.addAttribute("userDetails", new User());
            if(error != null) {
                model.addAttribute("errorMessage", error);
            }
            return "integrated:login";
        } else {
            return "redirect:/";
        }
    }
}
