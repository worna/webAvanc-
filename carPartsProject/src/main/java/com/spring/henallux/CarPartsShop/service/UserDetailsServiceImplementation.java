package com.spring.henallux.CarPartsShop.service;

import com.spring.henallux.CarPartsShop.dataAccess.dao.UserDAO;
import com.spring.henallux.CarPartsShop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImplementation(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =  userDAO.findByEmail(email);
        if(user != null){
            return user;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
