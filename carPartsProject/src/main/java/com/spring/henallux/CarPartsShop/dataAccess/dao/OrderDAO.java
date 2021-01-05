package com.spring.henallux.CarPartsShop.dataAccess.dao;

import com.spring.henallux.CarPartsShop.dataAccess.entity.OrderEntity;
import com.spring.henallux.CarPartsShop.dataAccess.entity.ProductOrderEntity;
import com.spring.henallux.CarPartsShop.dataAccess.repository.OrderRepository;
import com.spring.henallux.CarPartsShop.dataAccess.repository.ProductOrderRepository;
import com.spring.henallux.CarPartsShop.dataAccess.util.ProviderConverter;
import com.spring.henallux.CarPartsShop.model.Order;
import com.spring.henallux.CarPartsShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;


@Service
@Transactional
public class OrderDAO implements OrderDataAccess {
    private OrderRepository orderRepository;
    private ProductOrderRepository productOrderRepository;
    private ProviderConverter providerConverter;


    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProductOrderRepository productOrderRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
        this.providerConverter = providerConverter;

    }

    public Order findById (int id){
        OrderEntity orderEntity = orderRepository.findById(id);
        Order order = providerConverter.orderEntityToOrderModel(orderEntity);
        return order;
    }
    public void addOrder(HashMap<Product, Integer> productsInCart){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setDate();
        orderEntity.setPaymentDate();
        //recuperer la promo
        orderEntity.setPromotionEntity();
        //récupérer l'user
        orderEntity.setUserEntity();
        productsInCart.forEach((product, quantity) -> {
            ProductOrderEntity productOrderEntity = new ProductOrderEntity();
            productOrderEntity.setOrderEntity(orderEntity);
            //chercher l'entité du produit
            productOrderEntity.setProductEntity();
            productOrderEntity.setQuantity(quantity);
            productOrderRepository.save(productOrderEntity);
        });
        orderRepository.save(orderEntity);
    }
}
