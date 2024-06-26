package com.amazon.cart;

public class CartItem {
    private int id;
    private int productId;
    private int userId;
    private String productName;
    private double price;
    private String category;
    private int quantity;
	public CartItem(int id, int productId, int userId, String productName, double price, String category,
			int quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	public CartItem() {
		super();
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int i) {
		this.userId = i;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", productId=" + productId + ", userId=" + userId + ", productName=" + productName
				+ ", price=" + price + ", category=" + category + ", quantity=" + quantity + "]";
	}

   
}
