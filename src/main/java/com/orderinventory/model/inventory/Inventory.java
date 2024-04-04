package com.orderinventory.model.inventory;

import java.io.Serializable;

import com.orderinventory.model.products.Products;
import com.orderinventory.model.stores.Stores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private int inventoryId;
	@Column(name="product_inventory")
	private int productInventory;
	
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public int getProductInventory() {
		return productInventory;
	}
	public void setProductInventory(int productInventory) {
		this.productInventory = productInventory;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public Stores getStores() {
		return stores;
	}
	public void setStores(Stores stores) {
		this.stores = stores;
	}
	public Inventory(int inventoryId, int productInventory) {
		super();
		this.inventoryId = inventoryId;
		this.productInventory = productInventory;
	}
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Products products;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	private Stores stores;
	
	
	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", productInventory=" + productInventory + "]";
	}
	

}
