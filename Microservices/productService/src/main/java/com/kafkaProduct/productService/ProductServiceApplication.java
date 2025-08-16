package com.kafkaProduct.productService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.kafkaProduct.controller")
@ComponentScan(basePackages = "com.kafkaProduct.DTO")
@ComponentScan(basePackages = "com.kafkaProduct.service")
@EntityScan(basePackages = "com.kafkaProduct.entity")
@EnableJpaRepositories(basePackages = "com.kafkaProduct.repositoty")
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
