package com.spring.henallux.carPartsProject.dataAccess.repository;

import com.spring.henallux.carPartsProject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String>{
    UserEntity findByEmail(String email);
}
