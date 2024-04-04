package com.orderinventory.model.customers;

import java.io.Serializable;
import java.util.List;

import com.orderinventory.model.orders.Orders;
import com.orderinventory.model.shipments.Shipments;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customers implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private int customerId;
	@Column(name="email_address")
	private String emailAddress;
	@Column(name="full_name")
	private String fullName;
	
	public Customers(int customerId, String emailAddress, String fullName) {
		super();
		this.customerId = customerId;
		this.emailAddress = emailAddress;
		this.fullName = fullName;
	}
	public Customers() {
		
	}
	@OneToMany(mappedBy="customers",cascade=CascadeType.ALL)
	private List<Shipments> shipments;
	
	@OneToMany(mappedBy="customers",cascade=CascadeType.ALL)
	private List<Orders> orders;
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Shipments> getShipments() {
		return shipments;
	}
	public void setShipments(List<Shipments> shipments) {
		this.shipments = shipments;
	}
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", emailAddress=" + emailAddress + ", fullName=" + fullName
				+ "]";
	}
	
	
	

}
