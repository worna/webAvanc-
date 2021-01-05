package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.dataAccess.dao.OrderDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductDAO;
import com.spring.henallux.CarPartsShop.dataAccess.entity.OrderEntity;
import com.spring.henallux.CarPartsShop.model.Order;
import com.spring.henallux.CarPartsShop.model.Product;
import com.spring.henallux.CarPartsShop.model.ProductInCart;
import com.spring.henallux.CarPartsShop.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping(value = "/buy/{id}")
@SessionAttributes({Constants.SESSION_CART})
public class BuyController {

    private OrderDAO orderDAO;
    private ProductDAO productDAO;

    @Autowired
    public BuyController(ProductDAO productDAO, OrderDAO orderDAO){
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model, @PathVariable String id, HttpServletRequest request) {
        Order order = orderDAO.findById(Integer.parseInt(id));
        System.out.println(order);
        if(order == null || !order.getUser().getEmail().equalsIgnoreCase(request.getUserPrincipal().getName())){
            return "redirect:/404";
        }

        model.addAttribute("title", "Car parts - Buy");
        model.addAttribute("products", new ArrayList<Product>());

        return "integrated:buy";
    }
}
