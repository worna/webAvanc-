package com.spring.henallux.carPartsProject.dataAccess.dao;


import com.spring.henallux.carPartsProject.model.User;

public interface UserDataAccess {
    User findByEmail (String email);
    void addUser(User user);
}
