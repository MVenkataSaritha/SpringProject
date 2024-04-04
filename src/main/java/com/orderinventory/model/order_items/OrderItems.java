package com.orderinventory.model.order_items;

import java.io.Serializable;

import com.orderinventory.model.customers.Customers;
import com.orderinventory.model.orders.Orders;
import com.orderinventory.model.products.Products;
import com.orderinventory.model.shipments.Shipments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_items")
public class OrderItems implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	@Column(name="line_item_id")
	private int lineItemId;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="quantity")
	private int quantity;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getLineItemId() {
		return lineItemId;
	}
	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public Shipments getShipments() {
		return shipments;
	}
	public void setShipments(Shipments shipments) {
		this.shipments = shipments;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public OrderItems(int orderId, int lineItemId, double unitPrice, int quantity, Shipments shipments, Orders orders,
			Products products) {
		super();
		this.orderId = orderId;
		this.lineItemId = lineItemId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.shipments = shipments;
		this.orders = orders;
		this.products = products;
	}
	
	

	public OrderItems() {
	}



	@ManyToOne
	@JoinColumn(name="shipment_id")
	private Shipments shipments;
	
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Orders orders;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Products products;
	
	
	@Override
	public String toString() {
		return "OrderItems [orderId=" + orderId + ", lineItemId=" + lineItemId + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", shipments=" + shipments + ", orders=" + orders + ", products="
				+ products + "]";
	}
	
	
}
