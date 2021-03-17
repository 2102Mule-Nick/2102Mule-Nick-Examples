package com.revature.dao;

import org.springframework.stereotype.Component;

import com.revature.pojo.Item;

public interface InventoryDao {

	public void updateQuantity(Item item, int quantity);
	
}
