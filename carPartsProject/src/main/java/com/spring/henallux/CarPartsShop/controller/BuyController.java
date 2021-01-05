package com.spring.henallux.CarPartsShop.controller;

import com.spring.henallux.CarPartsShop.dataAccess.dao.OrderDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductDAO;
import com.spring.henallux.CarPartsShop.dataAccess.dao.ProductOrderDAO;
import com.spring.henallux.CarPartsShop.dataAccess.entity.OrderEntity;
import com.spring.henallux.CarPartsShop.model.Order;
import com.spring.henallux.CarPartsShop.model.Product;
import com.spring.henallux.CarPartsShop.model.ProductInCart;
import com.spring.henallux.CarPartsShop.model.ProductOrder;
import com.spring.henallux.CarPartsShop.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


@Controller
@RequestMapping(value = "/buy/{id}")
@SessionAttributes({Constants.SESSION_CART})
public class BuyController {

    private OrderDAO orderDAO;
    private ProductOrderDAO productOrderDAO;

    @Autowired
    public BuyController(ProductOrderDAO productOrderDAO, OrderDAO orderDAO){
        this.productOrderDAO = productOrderDAO;
        this.orderDAO = orderDAO;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model, @PathVariable String id, HttpServletRequest request) {
        Order order = orderDAO.findById(Integer.parseInt(id));
        if(order == null || order.getPaymentDate() != null || !order.getUser().getEmail().equalsIgnoreCase(request.getUserPrincipal().getName())){
            return "redirect:/404";
        }

        ArrayList<ProductOrder> productOrders = productOrderDAO.findByOrderId(order.getId());

        model.addAttribute("title","Car parts shop");
        model.addAttribute("orderId", order.getId());
        model.addAttribute("products", productOrders);

        return "integrated:buy";
    }

    @RequestMapping (value= "/success", method = RequestMethod.GET)
    public String confirmPayment(@PathVariable String id, HttpServletRequest request){
        Order order = orderDAO.findById(Integer.parseInt(id));
        if(order == null || order.getPaymentDate() != null || !order.getUser().getEmail().equalsIgnoreCase(request.getUserPrincipal().getName())){
            return "redirect:/404";
        }

        order.setPaymentDate(new Date(System.currentTimeMillis()));
        orderDAO.updateDate(order);

        return "redirect:/orders";

    }
}
