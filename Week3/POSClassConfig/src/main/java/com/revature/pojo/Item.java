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
//constructor chain
// class NewItem extends Item {}
// new NewItem() -> Item() -> Item(paramaters) -> Object()
// class NewNewItem extends NewItem{}
// new NewNewItem() -> NewItem() -> Item() -> Item(parameters) -> Object()
public class Item {

	// final says a value cannot be changed
	//classes - cannot be derived (extended)
	//methods - cannot be overriden
	//variables - cannot changed, for primatives cannot change initial value, for objects you cannot rereferrence them
	private final int productId;

	private float cost;

	private String itemName;

	private int quantity;

	private float discount;

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
	/*
	 * Object Class -> parent of all classes in Java
	 * If you do not extend another class, you inherit from the Object class
	 */
	//new Item(); -> Item(default values) -> parent class constructor
	public Item() {
		//the first line, of any constructor is super() or this()
		//this() refers to another constructor in this class
		//if neither are called explicitly, super() is called implicitly
		this(1, 3.0f, "default-item-name", 1, 0.0f);
		//Constructor - create object instance of the class, sets the initial state
		// Java does provide a default constructor, only if you did not write your own
	}

	/*
	 * Overloaded constructor, can also overload methods
	 * Two methods in the same class, with the same name, but different parameter list
	 */
	public Item(int productId, float cost, String itemName, int quantity, float discount) {
		super(); //referencing the parent classes constructor
		this.productId = productId;
		this.setCost(cost);
		this.setItemName(itemName);
		this.setQuantity(quantity);
		this.setDiscount(discount);
	}
	
	
}
