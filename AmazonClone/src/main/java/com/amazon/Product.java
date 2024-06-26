package com.amazon;

public class Product {
    private int id;
    private String productName;
    private double price;
    private String category;
    private String imageName;
    private int qty;

    // Constructor, getters, and setters
    public Product(int id, String productName, double price, String category, String imageName) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.imageName = imageName;
    }

    

	public Product(int id, String productName, double price, String category, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.qty = quantity;
	}



	public int getQty() {
		
		System.out.println("Hiiiii"+qty);
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	// Getters
    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
    	System.out.println(category);
        return category;
    }

    public String getImageName() {
        return imageName;
    }
    
    
    
}
