package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.inventoryEntity.Inventory;
import com.kafka.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	/*public void updateInventory(String skuCode) {
		Inventory item = inventoryRepository.findById(skuCode).orElse(new Inventory(skuCode, 100)); // default quantity
		item.setQuantity(item.getQuantity() - 1);
		inventoryRepository.save(item);
	}*/
	
	public void addInventory(Inventory msg) {
		inventoryRepository.save(msg);
	}
}
