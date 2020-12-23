package com.spring.henallux.carPartsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CarPartsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPartsProjectApplication.class, args);
	}

}
