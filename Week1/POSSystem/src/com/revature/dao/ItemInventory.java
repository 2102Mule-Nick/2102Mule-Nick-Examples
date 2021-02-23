package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Item;

public class ItemInventory {
	
	private List<Item> itemList;

	public List<Item> getItemList() {
		return itemList;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}
	
	public ItemInventory() {
		this.itemList = new ArrayList<>();
	}
	
	public String toString() {
		
		String ret = "";
		
		for (Item item : itemList) {
			ret += item.getItemName();
			ret += ";";
		}
		
		return ret;
	}

}
