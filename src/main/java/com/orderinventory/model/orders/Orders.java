package com.orderinventory.model.orders;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.orderinventory.model.customers.Customers;
import com.orderinventory.model.inventory.Inventory;
import com.orderinventory.model.order_items.OrderItems;
import com.orderinventory.model.stores.Stores;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="orders")
public class Orders implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	@Column(name="order_tms")
	private Timestamp orderTms;
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public Stores getStores() {
		return stores;
	}
	public void setStores(Stores stores) {
		this.stores = stores;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	@Column(name="order_status")
	private String orderStatus;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Timestamp getOrderTms() {
		return orderTms;
	}
	public void setOrderTms(Timestamp orderTms) {
		this.orderTms = orderTms;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Orders(int orderId, Timestamp orderTms, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderTms = orderTms;
		this.orderStatus = orderStatus;
	}
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customers customers;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	private Stores stores;
	
	@OneToMany(mappedBy="orders", cascade=CascadeType.ALL)
	private List<OrderItems> orderItems;
	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderTms=" + orderTms + ", orderStatus=" + orderStatus + "]";
	}
}
