package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.DTO.OrderRequest;
import com.kafka.orderEntity.Order;
import com.kafka.orderReposetory.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderProducer orderProducer;

	public Order placeOrder(OrderRequest request) {
		Order order = new Order();
		order.setProductName(request.getProductName());
		order.setQuantity(request.getQuantity());
		order.setPrice(request.getPrice());
		System.out.println("Order before save:");
		System.out.println("Product Name: " + order.getProductName());
		System.out.println("Quantity: " + order.getQuantity());
		System.out.println("Price: " + order.getPrice());


		Order savedOrder = orderRepository.save(order);

		// Send Kafka message
		String message = "Order placed: " + savedOrder.getId();
		orderProducer.sendOrderNotification(message);

		return savedOrder;
	}
}
