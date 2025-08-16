package com.kafkaProduct.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafkaProduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
