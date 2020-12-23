package com.spring.henallux.carPartsProject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AddUsers {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("password");
        System.out.println(password);
    }
}
