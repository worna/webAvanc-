package com.spring.henallux.CarPartsShop.dataAccess.dao;

import com.spring.henallux.CarPartsShop.dataAccess.entity.OrderEntity;
import com.spring.henallux.CarPartsShop.dataAccess.entity.ProductOrderEntity;
import com.spring.henallux.CarPartsShop.dataAccess.repository.OrderRepository;
import com.spring.henallux.CarPartsShop.dataAccess.repository.ProductOrderRepository;
import com.spring.henallux.CarPartsShop.dataAccess.repository.ProductRepository;
import com.spring.henallux.CarPartsShop.dataAccess.repository.UserRepository;
import com.spring.henallux.CarPartsShop.dataAccess.util.ProviderConverter;
import com.spring.henallux.CarPartsShop.model.Order;
import com.spring.henallux.CarPartsShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.HashMap;


@Service
@Transactional
public class OrderDAO implements OrderDataAccess {
    private OrderRepository orderRepository;
    private ProductOrderRepository productOrderRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private ProviderConverter providerConverter;


    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProductOrderRepository productOrderRepository, UserRepository userRepository,  ProductRepository productRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;

    }

    public Order findById (int id){
        OrderEntity orderEntity = orderRepository.findById(id);
        Order order = providerConverter.orderEntityToOrderModel(orderEntity);
        return order;
    }
    public void addOrder(HashMap<Product, Integer> productsInCart, HttpServletRequest request){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        orderEntity.setPaymentDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        orderEntity.setReceptionDate(null);
        //recuperer la promo
        orderEntity.setPromotionEntity(null);
        orderEntity.setUserEntity(userRepository.findByEmail(request.getUserPrincipal().getName()));
        System.out.println(orderEntity.getDate()+"|"+orderEntity.getReceptionDate());
        orderRepository.save(orderEntity);
        productsInCart.forEach((product, quantity) -> {
            ProductOrderEntity productOrderEntity = new ProductOrderEntity();
            productOrderEntity.setOrderEntity(orderEntity);
            productOrderEntity.setProductEntity(productRepository.findById(product.getId()));
            productOrderEntity.setQuantity(quantity);
            productOrderRepository.save(productOrderEntity);
        });

    }
}
