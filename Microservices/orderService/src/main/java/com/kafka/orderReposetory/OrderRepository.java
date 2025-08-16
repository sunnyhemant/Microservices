package com.kafka.orderReposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.orderEntity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
