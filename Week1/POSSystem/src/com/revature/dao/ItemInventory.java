package com.revature.dao;

import java.util.Iterator;
import java.util.LinkedList;

import java.util.List;

import com.revature.pojo.Item;

/*
 * Java Scopes - there are four scopes in Java
 * Static/Class - use the static keyword
 * Instance/Object - within a class, not in a method, does not have static keyword
 * Method/Parameter - declared in the method, or a parameter passed in
 * Block/Loop - declared inside a block {} or defined in a loop statement or if definition, or switch
 * 
 * From an inner scope we can view variables defined in an outer scope, but we cannot see variables from an outer scope defined in an inner scope
 */
public class ItemInventory {
	
	//static scope
	private final static List<Item> ITEM_LIST = new LinkedList<>();
	
	//instance scope
	private String inventoryName;
	
	public String getInventoryName() {
		System.out.println(ITEM_LIST);
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public static List<Item> getItemList() {
		//System.out.println(inventoryName); out of scope, trying to access an instance variable from a static context
		return ITEM_LIST;
	}
	
	public static Item getItemByProductId(int productId) {
		
		Iterator<Item> iter = ITEM_LIST.iterator();
		
		while (iter.hasNext()) {
			Item item = iter.next();
			if(item.getProductId() == productId) {
				return item;
			}
		}
		
		return null;
		
	}

	//static method is inside the static scope
	public static void addItem(Item item) {
		ITEM_LIST.add(item);
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
		
		//now ret is in method/parameter
		String ret = "";
		
		for (Item item : ITEM_LIST) {
			//String ret =""; cannot access outside of block/loop
			//this item is inside block scope
			ret += item.getItemName();
			ret += ";";
			//for (;;) {
				//System.out.println(item);
			//}
		}
		
		//System.out.println(item);  out of scope
		
		return ret;
	}
	
	public static void newMethod() {
		//System.out.println(ret); in a different method, out of scope
	}

}
