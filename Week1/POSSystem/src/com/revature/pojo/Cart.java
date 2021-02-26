package com.revature.pojo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private int cartId;	//default value = 0
	
	private List<Item> items; //default value = null
	
	private float total; //default value = 0.0
	
	private List<Integer> quantity; //Integer is a Wrapper class
	
	/*
	 * Wrapper class allows us to convert our primative values into an object
	 * int -> Integer byte ->Byte float -> Float... etc. for all primatives
	 */

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
		this(0, new ArrayList<Item>(), 0.0f, new ArrayList<Integer>());
	}
	
	public Cart(int cartId, List<Item> items, float total, List<Integer> quantity) {
		this.cartId = cartId;
		this.items = items;
		this.total = total;
		this.quantity = quantity;
	}

	{
		
		int myInt = 5;
		
		Integer myInteger = myInt; //Auto-boxing
		
		myInt = myInteger; //Auto-unboxing
		
		myInt = (int) myInteger;
		
		myInteger = (Integer) myInt;
		
	}
	
	public void addItem(Item item, int quantity) 
	{
		//updating item list, total, quantity
		items.add(item);
		total += item.getCost();
		this.quantity.add(quantity);
	}
	
	public boolean removeItem(int productId, int quantity) {
		//check if enough items to remove
		boolean found = false;
		int itemIndex = 0;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getProductId() == productId) {
				if(this.quantity.get(i) >= quantity) {
					found = true;
					itemIndex = i;
					break;
				}
				else {
					found = false;
					break;
				}
			}
		}
		if(found) {
			//update total
			total -= items.get(itemIndex).getCost() * quantity;
			//update quanity
			this.quantity.set(itemIndex, this.quantity.get(itemIndex) - quantity);
			if(this.quantity.get(itemIndex) <= 0) {
				this.quantity.remove(itemIndex);
				//update itemlist
				items.remove(itemIndex);
			}
			
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
