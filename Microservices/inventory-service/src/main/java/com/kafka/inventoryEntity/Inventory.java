package com.kafka.inventoryEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`inventorys`")
public class Inventory {

	@Id
	@Column (name = "order_id", nullable = false)
	private int orderId;
	@Column(name = "sku_code", nullable = false)
	private String skuCode;
	private Integer quantity;

	public Inventory() {
	}

	public Inventory(int orderId, String skuCode, Integer quantity) {
		super();
		this.orderId = orderId;
		this.skuCode = skuCode;
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
}
