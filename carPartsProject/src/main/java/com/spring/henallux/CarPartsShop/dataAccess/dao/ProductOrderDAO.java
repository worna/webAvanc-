package com.spring.henallux.CarPartsShop.dataAccess.dao;

import com.spring.henallux.CarPartsShop.dataAccess.entity.ProductOrderEntity;
import com.spring.henallux.CarPartsShop.dataAccess.repository.OrderRepository;
import com.spring.henallux.CarPartsShop.dataAccess.repository.ProductOrderRepository;
import com.spring.henallux.CarPartsShop.dataAccess.util.ProviderConverter;
import com.spring.henallux.CarPartsShop.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductOrderDAO implements ProductOrderDataAccess {

    private ProductOrderRepository productOrderRepository;
    private ProviderConverter providerConverter;
    private OrderRepository orderRepository;


    @Autowired
    public ProductOrderDAO(ProductOrderRepository productOrderRepository, OrderRepository orderRepository, ProviderConverter providerConverter) {
        this.productOrderRepository = productOrderRepository;
        this.providerConverter = providerConverter;
        this.orderRepository = orderRepository;
    }

    public ProductOrder findById (int id){
        ProductOrderEntity productOrderEntity = productOrderRepository.findById(id);
        ProductOrder productOrder = providerConverter.productOrderEntityToProductOrderModel(productOrderEntity);
        return productOrder;
    }

    public ArrayList<ProductOrder> findByOrderId (Integer orderId){
        ArrayList<ProductOrder> productOrders = new ArrayList<>();
        List<ProductOrderEntity> productOrderEntities = productOrderRepository.findAllByOrderEntity(orderRepository.findById(orderId));
        for(ProductOrderEntity productOrderEntity : productOrderEntities){
            productOrders.add(providerConverter.productOrderEntityToProductOrderModel(productOrderEntity));
        }
        return productOrders;
    }
}
