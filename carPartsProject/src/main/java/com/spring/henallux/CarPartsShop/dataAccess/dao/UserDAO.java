package com.spring.henallux.CarPartsShop.dataAccess.dao;

import com.spring.henallux.CarPartsShop.dataAccess.entity.UserEntity;
import com.spring.henallux.CarPartsShop.dataAccess.repository.UserRepository;
import com.spring.henallux.CarPartsShop.dataAccess.util.ProviderConverter;
import com.spring.henallux.CarPartsShop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDAO implements UserDataAccess {
    private UserRepository userRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter) {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    public User findByEmail (String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null) return null;
        User user = providerConverter.userEntityToUserModel(userEntity);
        return user;
    }
    public void addUser(User user) throws Exception{
        if(findByEmail(user.getEmail()) == null){
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setEnabled(true);
            user.setCredentialsNonExpired(true);
            user.setAuthorities("ROLE_USER");
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            UserEntity userEntity = providerConverter.userModelToUserEntity(user);
            userRepository.save(userEntity);
        } else {
            throw new Exception("User already exist");
        }
    }
}
