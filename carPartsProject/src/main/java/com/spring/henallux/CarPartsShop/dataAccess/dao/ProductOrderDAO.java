package com.spring.henallux.CarPartsShop.dataAccess.dao;

import com.spring.henallux.CarPartsShop.dataAccess.entity.ProductOrderEntity;
import com.spring.henallux.CarPartsShop.dataAccess.repository.ProductOrderRepository;
import com.spring.henallux.CarPartsShop.dataAccess.util.ProviderConverter;
import com.spring.henallux.CarPartsShop.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductOrderDAO implements ProductOrderDataAccess {
    private ProductOrderRepository productOrderRepository;
    private ProviderConverter providerConverter;


    @Autowired
    public ProductOrderDAO(ProductOrderRepository productOrderRepository, ProviderConverter providerConverter) {
        this.productOrderRepository = productOrderRepository;
        this.providerConverter = providerConverter;

    }

    public ProductOrder findById (int id){
        ProductOrderEntity productOrderEntity = productOrderRepository.findById(id);
        ProductOrder productOrder = providerConverter.productOrderEntityToProductOrderModel(productOrderEntity);
        return productOrder;
    }
}
