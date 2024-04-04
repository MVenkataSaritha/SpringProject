package com.orderinventory.model.products;

import java.io.Serializable;
import java.util.List;

import com.orderinventory.model.inventory.Inventory;
import com.orderinventory.model.order_items.OrderItems;
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
@Table(name="products")
public class Products implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="colour")
	private String colour;
	@Column(name="brand")
	private String brand;
	@Column(name="size")
	private int size;
	@Column(name="rating")
	private float rating;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getColour() {
		return colour;
	}
	public List<Inventory> getInventory() {
		return inventory;
	}
	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public Products(int productId, String productName, String colour, String brand, int size, float rating) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.colour = colour;
		this.brand = brand;
		this.size = size;
		this.rating = rating;
	}
	
	@OneToMany(mappedBy="products", cascade=CascadeType.ALL)
	private List<Inventory> inventory;
	
	@OneToMany(mappedBy="products", cascade=CascadeType.ALL)
	private List<OrderItems> orderItems;
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", colour=" + colour + ", brand="
				+ brand + ", size=" + size + ", rating=" + rating + "]";
	}
	
	

}
