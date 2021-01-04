package com.spring.henallux.CarPartsShop.dataAccess.dao;

import com.spring.henallux.CarPartsShop.dataAccess.entity.ProductEntity;

import com.spring.henallux.CarPartsShop.dataAccess.repository.ProductRepository;
import com.spring.henallux.CarPartsShop.dataAccess.util.ProviderConverter;
import com.spring.henallux.CarPartsShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductDAO implements ProductDataAccess {
    private ProductRepository productRepository;
    private ProviderConverter providerConverter;


    @Autowired
    public ProductDAO(ProductRepository productRepository, ProviderConverter providerConverter) {
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;

    }

    public Product findById (int id){
        ProductEntity productEntity = productRepository.findById(id);
        Product product = providerConverter.productEntityToProductModel(productEntity);
        return product;
    }
    public List<Product> findAll (){
        List<Product> products = new ArrayList<Product>();
        List<ProductEntity> productEntities = productRepository.findAll();
        for(int i = 0; i < productEntities.size(); i++){
            products.add(providerConverter.productEntityToProductModel(productEntities.get(i)));
        }
        return products;
    }
    public List<Product> findBySalableTrue (){
        List<Product> products = new ArrayList<Product>();
        List<ProductEntity> productEntities = productRepository.findBySalableTrue();
        for(int i = 0; i < productEntities.size(); i++){
            products.add(providerConverter.productEntityToProductModel(productEntities.get(i)));
        }
        return products;
    }
    public List<Product> findByCategoryEntity_CategoryId(Integer id) {
        List<Product> products = new ArrayList<Product>();
        List<ProductEntity> productEntities = productRepository.findByCategoryEntity_CategoryId(id);
        for(int i = 0; i < productEntities.size(); i++){
            products.add(providerConverter.productEntityToProductModel(productEntities.get(i)));
        }
        return products;
    }
    public void updateProduct(Integer id, Integer quantity){
        ProductEntity productEntity = productRepository.findById(id);
        productEntity.setQuantityLeft(productEntity.getQuantityLeft()-quantity);
        productRepository.save(productEntity);
    }
}
