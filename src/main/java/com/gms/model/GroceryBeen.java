package com.gms.model;

import java.sql.Date;

public class GroceryBeen {
	private int idgroocery;
	private String name;
	private String metrixType;
	private int quantity;
	private Date expiryDate;
	private String itemType;
	private int price;

	public int getIdgroocery() {
		return idgroocery;
	}

	public void setIdgroocery(int idgroocery) {
		this.idgroocery = idgroocery;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMetrixType() {
		return metrixType;
	}

	public void setMetrixType(String metrixType) {
		this.metrixType = metrixType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "GrooceryBeen [idgroocery=" + idgroocery + ", name=" + name + ", metrixType=" + metrixType
				+ ", quantity=" + quantity + ", expiryDate=" + expiryDate + ", itemType=" + itemType + ", price="
				+ price + "]";
	}
}
