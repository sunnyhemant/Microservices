package com.kafka.orderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableDiscoveryClient
@EnableKafka
@ComponentScan(basePackages = "com.kafka.controller")
@ComponentScan(basePackages = "com.kafka.DTO")
@ComponentScan(basePackages = "com.kafka.service")
@ComponentScan(basePackages = "com.kafka.config")
@EntityScan(basePackages = "com.kafka.orderEntity")
@EnableJpaRepositories(basePackages = "com.kafka.orderReposetory")
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
