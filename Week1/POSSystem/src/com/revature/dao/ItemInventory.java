package com.revature.dao;

import java.util.LinkedList;
import java.util.List;

import com.revature.pojo.Item;

public class ItemInventory {
	
	private final static List<Item> itemList = new LinkedList<>();

	public static List<Item> getItemList() {
		return itemList;
	}

	public static void addItem(Item item) {
		itemList.add(item);
	}
	
	/*
	 * overriding - form of runtime polymorphism
	 * allows us to write our own version of a parent method
	 * must be same name/parameter list as parent version
	 * 
	 * Object o;
	 * 
	 * ...some code...
	 * 
	 * o = myReturnMethod();
	 * 
	 * o.toString();
	 * 
	 */
	public static String print() {
		
		String ret ="";
		
		//String ret = "";
		
		for (Item item : itemList) {
			ret += item.getItemName();
			ret += ";";
		}
		
		return ret;
	}

}
