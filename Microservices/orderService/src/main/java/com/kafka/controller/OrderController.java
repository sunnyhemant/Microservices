package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.DTO.OrderRequest;
import com.kafka.orderEntity.Order;
import com.kafka.service.KafkaOrderProducer;
import com.kafka.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	private final KafkaOrderProducer producer;

    public OrderController(KafkaOrderProducer producer) {
        this.producer = producer;
    }

	@PostMapping("/addOrder")
	public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest request) {
		Order order = orderService.placeOrder(request);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@PostMapping("/orderSend")
	public ResponseEntity<String> placeOrder(@RequestBody String orderJson) {
        producer.sendOrder(orderJson);
        return ResponseEntity.ok("Order sent to Kafka.");
    }
}
