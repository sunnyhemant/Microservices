package com.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.inventoryEntity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}