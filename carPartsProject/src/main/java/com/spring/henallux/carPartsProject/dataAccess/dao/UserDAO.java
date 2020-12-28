package com.spring.henallux.carPartsProject.dataAccess.dao;

import com.spring.henallux.carPartsProject.dataAccess.entity.UserEntity;
import com.spring.henallux.carPartsProject.dataAccess.repository.UserRepository;
import com.spring.henallux.carPartsProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.carPartsProject.model.User;
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
    public void addUser(User user){
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setAuthorities("ROLE_USER");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        userRepository.save(userEntity);
    }
}
