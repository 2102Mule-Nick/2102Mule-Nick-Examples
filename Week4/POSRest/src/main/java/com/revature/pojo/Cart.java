package com.revature.pojo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private int cartId;	//default value = 0
	
	private List<Item> items; //default value = null
	
	private float total; //default value = 0.0
	
	private List<Integer> quantity; //Integer is a Wrapper class
	
	private int userId;
	
	/*
	 * Wrapper class allows us to convert our primative values into an object
	 * int -> Integer byte ->Byte float -> Float... etc. for all primatives
	 */

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public List<Item> getItems() {
		return items;
	}



	public void setItems(List<Item> items) {
		this.items = items;
	}



	public float getTotal() {
		return total;
	}



	public void setTotal(float total) {
		this.total = total;
	}



	public List<Integer> getQuantity() {
		return quantity;
	}



	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}

	public Cart() {
		this.items = new ArrayList<>();
		this.quantity = new ArrayList<>();
	}
	
	public Cart(int cartId, List<Item> items, float total, List<Integer> quantity, int userId) {
		super();
		this.cartId = cartId;
		this.items = items;
		this.total = total;
		this.quantity = quantity;
		this.userId = userId;
	}


	

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", items=" + items + ", total=" + total + ", quantity=" + quantity
				+ ", userId=" + userId + "]";
	}




	{
		
		int myInt = 5;
		
		Integer myInteger = myInt; //Auto-boxing
		
		myInt = myInteger; //Auto-unboxing
		
		myInt = (int) myInteger;
		
		myInteger = (Integer) myInt;
		
	}
	
}
