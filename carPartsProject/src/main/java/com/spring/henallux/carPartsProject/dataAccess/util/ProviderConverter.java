package com.spring.henallux.carPartsProject.dataAccess.util;

import com.spring.henallux.carPartsProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.carPartsProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.carPartsProject.dataAccess.entity.UserEntity;
import com.spring.henallux.carPartsProject.model.Category;
import com.spring.henallux.carPartsProject.model.Image;
import com.spring.henallux.carPartsProject.model.Product;
import com.spring.henallux.carPartsProject.model.User;
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
        user.setBirthDate(userEntity.getBirthDate());
        user.setGender(userEntity.getGender());
        user.setAccountNonExpired(userEntity.isAccountNonExpired());
        user.setAccountNonLocked(userEntity.isAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.isCredentialsNonExpired());
        user.setEnabled(userEntity.isEnabled());
        user.setAuthorities(userEntity.getAuthorities());
        return user;
    }
    public Product productEntityToProductModel(ProductEntity productEntity){
        Product product = mapper.map(productEntity, Product.class);
        product.setCategory(categoryEntityToCategoryModel(productEntity.getCategoryEntity()));
        product.setSalable(productEntity.isSalable());
        return product;

    }
    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = mapper.map(categoryEntity, Category.class);
        return category;
    }

}
