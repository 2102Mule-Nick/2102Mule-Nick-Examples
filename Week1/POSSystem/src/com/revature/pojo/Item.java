package com.revature.pojo;

/*
 * Access Levels: what parts of code in the program can access and modify 
 * private - only for the class it is defined in
 * public - all classes in the program
 * protected - sub classes and parents, and package of class defined in
 * default [no access modifier] - only in the package (package private)
 * 
 * 				same class | sub-class in package | non-sub-class in package | sub-class outside package | non-subclass outside package
 * 
 * public 			+				+						+							+							+
 * 
 * protected		+				+						+							+							-
 * 
 * default			+				+						+							-							-
 * 
 * private			+				-						-							-							-
 * 
 */

public class Item {

	private int productId;

	private float cost;

	private String itemName;

	private int quantity;

	private float discount;

	public void setProductId(int productId) {

		if (productId > 0) {

			this.productId = productId;
		}

	}

	public int getProductId() {

		/*
		 * int productId = 7;
		 * 
		 * System.out.println(productId);
		 */

		return this.productId; // this refers to the instance object that the method was called on
	}
	
	public void setCost(float cost) {
		if (cost > 0) {

			this.cost = cost;
		}
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getCost() {
		return cost;
	}
	
	public Item() {
		//Constructor - create object instance of the class, sets the initial state
		// Java does provide a default constructor, only if you did not write your own
	}

	public Item(int productId, float cost, String itemName, int quantity, float discount) {
		super();
		this.setProductId(productId);
		this.setCost(cost);
		this.setItemName(itemName);
		this.setQuantity(quantity);
		this.setDiscount(discount);
	}
	
	
}
