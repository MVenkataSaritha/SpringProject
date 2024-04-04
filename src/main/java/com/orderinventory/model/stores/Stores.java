package com.orderinventory.model.stores;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.orderinventory.model.inventory.Inventory;
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
@Table(name="stores")
public class Stores implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id")
	private int storeId;
	@Column(name="store_name")
	private String storeName;
	@Column(name="web_address")
	private String webAddress;
	@Column(name="physical_address")
	private String physicalAddress;
	@Column(name="latitude")
	private double latitude;
	@Column(name="longitude")
	private double longitude;
	@Column(name="logo")
	private byte[] logo;
	@Column(name="logo_mime_type")
	private String logoMimeType;
	@Column(name="logo_file_name")
	private String logoFileName;
	@Column(name="logoCharSet")
	private String logoCharset;
	@Column(name="logo_last_updated")
	private Date logoLastUpdated;
	
	public Stores(int storeId, String storeName, String webAddress, String physicalAddress, double latitude,
			double longitude, byte[] logo, String logoMimeType, String logoFileName, String logoCharset,
			Date logoLastUpdated) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.webAddress = webAddress;
		this.physicalAddress = physicalAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.logo = logo;
		this.logoMimeType = logoMimeType;
		this.logoFileName = logoFileName;
		this.logoCharset = logoCharset;
		this.logoLastUpdated = logoLastUpdated;
	}
	
	@OneToMany(mappedBy="stores", cascade=CascadeType.ALL)
	private List<Shipments> shipments;
	
	@OneToMany(mappedBy="stores", cascade=CascadeType.ALL)
	private List<Inventory> inventory;
	
	public List<Inventory> getInventory() {
		return inventory;
	}
	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getWebAddress() {
		return webAddress;
	}
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getLogoMimeType() {
		return logoMimeType;
	}
	public void setLogoMimeType(String logoMimeType) {
		this.logoMimeType = logoMimeType;
	}
	public String getLogoFileName() {
		return logoFileName;
	}
	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}
	public String getLogoCharset() {
		return logoCharset;
	}
	public void setLogoCharset(String logoCharset) {
		this.logoCharset = logoCharset;
	}
	public Date getLogoLastUpdated() {
		return logoLastUpdated;
	}
	public void setLogoLastUpdated(Date logoLastUpdated) {
		this.logoLastUpdated = logoLastUpdated;
	}
	
	public List<Shipments> getShipments() {
		return shipments;
	}
	public void setShipments(List<Shipments> shipments) {
		this.shipments = shipments;
	}
	@Override
	public String toString() {
		return "Stores [storeId=" + storeId + ", storeName=" + storeName + ", webAddress=" + webAddress
				+ ", physicalAddress=" + physicalAddress + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", logo=" + Arrays.toString(logo) + ", logoMimeType=" + logoMimeType + ", logoFileName="
				+ logoFileName + ", logoCharset=" + logoCharset + ", logoLastUpdated=" + logoLastUpdated + "]";
	}
	
}
