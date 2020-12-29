package com.spring.henallux.CarPartsShop.dataAccess.dao;


import com.spring.henallux.CarPartsShop.model.User;

public interface UserDataAccess {
    User findByEmail (String email);
    void addUser(User user);
}
