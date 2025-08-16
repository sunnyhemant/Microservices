package com.kafka.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.inventoryEntity.Inventory;
import com.kafka.repository.InventoryRepository;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryRepository inventoryRepository;

	// GET inventory by SKU
	@GetMapping("/{skuCode}")
	public ResponseEntity<Inventory> getInventory(@PathVariable String skuCode) {
		return inventoryRepository.findById(skuCode).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// POST create new inventory
	@PostMapping
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
		Inventory saved = inventoryRepository.save(inventory);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	// PUT update inventory quantity
	@PutMapping("/update/{orderId}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable String orderId, @RequestBody Inventory updatedData) {
		return inventoryRepository.findById(orderId).map(existing -> {
			existing.setQuantity(updatedData.getQuantity());existing.setSkuCode(updatedData.getSkuCode());
			return new ResponseEntity<>(inventoryRepository.save(existing), HttpStatus.OK);
		}).orElse(ResponseEntity.notFound().build());
	}

	// DELETE inventory by SKU
	@DeleteMapping("/deleteById/{orderId}")
	public ResponseEntity<Void> deleteInventory(@PathVariable String orderId) {
		if (inventoryRepository.existsById(orderId)) {
			inventoryRepository.deleteById(orderId);
			inventoryRepository.deleteAll();
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	//delete total values
	@DeleteMapping("/deleteTotalValues")
	public void deleteTotalInventory(){
		inventoryRepository.deleteAll();
	}

	// GET all inventory items
	@GetMapping("/allInventory")
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}
}
