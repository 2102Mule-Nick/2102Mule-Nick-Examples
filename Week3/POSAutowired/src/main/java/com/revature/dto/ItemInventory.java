package com.revature.dto;

import java.io.Serializable;

import com.revature.pojo.Item;

public class ItemInventory implements Serializable {
	
	private Item item;
	
	private int quantity;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ItemInventory(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}

	public ItemInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ItemInventory [item=" + item + ", quantity=" + quantity + "]";
	}

}
