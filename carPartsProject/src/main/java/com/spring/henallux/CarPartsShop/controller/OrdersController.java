package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.dataAccess.dao.CategoryTranslationDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.OrderDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductOrderDAO;
import com.spring.henallux.CarPartsShop.model.*;
import com.spring.henallux.CarPartsShop.utils.ShoppingCart;
import com.spring.henallux.CarPartsShop.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(value="/orders")
public class OrdersController {

    private OrderDAO orderDAO;
    private ProductOrderDAO productOrderDAO;

    @Autowired
    public OrdersController(OrderDAO orderDAO, ProductOrderDAO productOrderDAO){
        this.orderDAO = orderDAO;
        this.productOrderDAO = productOrderDAO;
    }


    @RequestMapping ( method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request){
        List<Order> results = orderDAO.findByUser(request);
        HashMap<Order, ArrayList<ProductOrder>> orders = new HashMap<>();

        for(Order order : results){
            ArrayList<ProductOrder> productOrders = productOrderDAO.findByOrderId(order.getId());
            orders.put(order, productOrders);
        }

        model.addAttribute("orders", orders);
        model.addAttribute("title","Car parts shop");
        
        return "integrated:orders";
    }
}
