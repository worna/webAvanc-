package com.spring.henallux.CarPartsShop.dataAccess.util;

import com.spring.henallux.CarPartsShop.model.*;
import com.spring.henallux.CarPartsShop.dataAccess.entity.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    public User userEntityToUserModel(UserEntity userEntity){
        User user = new User();
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setLastName(userEntity.getLastName());
        user.setFirstName(userEntity.getFirstName());
        user.setPhoneNumber(userEntity.getPhoneNumber());
        user.setStreet(userEntity.getStreet());
        user.setCity(userEntity.getCity());
        user.setPostalCode(userEntity.getPostalCode());
        user.setCountry(userEntity.getCountry());
        user.setBirthDate(new java.util.Date(userEntity.getBirthDate().getTime()));
        user.setGender(userEntity.getGender());
        user.setAccountNonExpired(userEntity.isAccountNonExpired());
        user.setAccountNonLocked(userEntity.isAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.isCredentialsNonExpired());
        user.setEnabled(userEntity.isEnabled());
        user.setAuthorities(userEntity.getAuthorities());
        return user;
    }
    public UserEntity userModelToUserEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setLastName(user.getLastName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setStreet(user.getStreet());
        userEntity.setCity(user.getCity());
        userEntity.setPostalCode(user.getPostalCode());
        userEntity.setCountry(user.getCountry());
        userEntity.setBirthDate(new java.sql.Date(user.getBirthDate().getTime()));
        userEntity.setGender(user.getGender());
        userEntity.setAccountNonExpired(user.isAccountNonExpired());
        userEntity.setAccountNonLocked(user.isAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userEntity.setEnabled(user.isEnabled());
        userEntity.setAuthorities(user.getAuthoritiesString());
        return userEntity;
    }
    public Product productEntityToProductModel(ProductEntity productEntity){
        Product product = mapper.map(productEntity, Product.class);
        product.setCategory(categoryEntityToCategoryModel(productEntity.getCategoryEntity()));
        product.setSalable(productEntity.isSalable());
        return product;

    }
    public Order orderEntityToOrderModel(OrderEntity orderEntity){
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setDate(new java.util.Date(orderEntity.getDate().getTime()));
        if(orderEntity.getPaymentDate() != null)
            order.setPaymentDate(new java.util.Date(orderEntity.getPaymentDate().getTime()));
        if(orderEntity.getReceptionDate() != null)
            order.setReceptionDate(new java.util.Date(orderEntity.getReceptionDate().getTime()));
        if(orderEntity.getPromotionEntity() != null)
            order.setPromotion(promotionEntityToPromotionModel(orderEntity.getPromotionEntity()));
        order.setUser(userEntityToUserModel(orderEntity.getUserEntity()));
        return order;
    }
    public ProductOrder productOrderEntityToProductOrderModel(ProductOrderEntity productOrderEntity){
        ProductOrder productOrder = mapper.map(productOrderEntity, ProductOrder.class);
        productOrder.setProduct(productEntityToProductModel(productOrderEntity.getProductEntity()));
        productOrder.setOrder(orderEntityToOrderModel(productOrderEntity.getOrderEntity()));
        return productOrder;
    }
    public Promotion promotionEntityToPromotionModel(PromotionEntity promotionEntity){
        Promotion promotion = new Promotion();
        promotion.setId(promotionEntity.getId());
        promotion.setName(promotionEntity.getName());
        promotion.setPercent(promotionEntity.getPercent());
        promotion.setStartDate(new java.util.Date(promotionEntity.getStartDate().getTime()));
        promotion.setEndDate(new java.util.Date(promotionEntity.getEndDate().getTime()));
        return promotion;
    }
    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = mapper.map(categoryEntity, Category.class);
        return category;
    }
    public CategoryTranslation categoryTranslationEntityToCategoryTranslationModel(CategoryTranslationEntity categoryTranslationEntity){
        CategoryTranslation categoryTranslation = new CategoryTranslation(categoryTranslationEntity.getName(),categoryTranslationEntity.getCategoryId(),categoryTranslationEntity.getLanguageName());
        return categoryTranslation;
    }

}
