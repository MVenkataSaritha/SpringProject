package com.orderinventory.model.shipments;

import java.io.Serializable;
import java.util.List;

import com.orderinventory.model.customers.Customers;
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
@Table(name="shipments")
public class Shipments implements Serializable{
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shipment_id")
	private int shipmentId;
	@Column(name="delivery_address")
	private String deliveryAddress;
	@Column(name="shipment_status")
	private String shipmentStatus;
	
	public Shipments(int shipmentId, String deliveryAddress, String shipmentStatus) {
		super();
		this.shipmentId = shipmentId;
		this.deliveryAddress = deliveryAddress;
		this.shipmentStatus = shipmentStatus;
	}
	@ManyToOne
	@JoinColumn(name="store_id")
	private Stores stores;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customers customers;
	
	@OneToMany(mappedBy="shipments",cascade=CascadeType.ALL)
	private List<OrderItems> orderItems;
	
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public int getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getShipmentStatus() {
		return shipmentStatus;
	}
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	
	public Stores getStores() {
		return stores;
	}
	public void setStores(Stores stores) {
		this.stores = stores;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "Shipments [shipmentId=" + shipmentId + ", deliveryAddress=" + deliveryAddress + ", shipmentStatus="
				+ shipmentStatus + "]";
	}
	
	

}
