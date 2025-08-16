package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.inventoryEntity.Inventory;

@Service
public class InventoryKafkaConsumer {

    @Autowired
    private InventoryService inventoryService;
 
    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void consumer(String message) {
        System.out.println("Received order event: " + message);
     // TODO: Deserialize JSON and update inventory DB
        Inventory inventory = new Inventory();
        ObjectMapper mapper = new ObjectMapper();
        try {
			inventory = mapper.readValue(message, Inventory.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        inventoryService.addInventory(inventory);
    }
}
