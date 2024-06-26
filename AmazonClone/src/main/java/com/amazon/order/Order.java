package com.amazon.order;

import java.util.Date;

public class Order {
    private int id;
    private int productId;
    private int userId;
    private int cartId;
    private String productName;
    private String userName;
    private double price;
    private int quantity;
  private String category;
    private String status;
    private Date orderDate;
    private double totalAmount;

    // Constructors
    public Order() {
    
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

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCartId() {
		return cartId;
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Order(int id, int productId, int userId, int cartId, String productName, String userName, double price,
			int quantity, String status, double totalAmount) {
		super();
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.cartId = cartId;
		this.productName = productName;
		this.userName = userName;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.totalAmount = totalAmount;
	}
	public Order(int id, int userId, int productId,String productName, String category, int quantity, double totalAmount, Date orderDate) {
        this.id = id;
        this.userId = userId;
        this.productId =productId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }
	
    
}