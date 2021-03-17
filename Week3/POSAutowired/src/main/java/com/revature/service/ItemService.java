package com.revature.service;

import java.util.List;

import com.revature.pojo.Item;

public interface ItemService {
	
	public List<Item> getAllItems();
	
	public Item getItemByItemName(String itemName);

}
