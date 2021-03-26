package com.revature.ws;

import com.revature.pojo.Item;

public class ItemRestockImpl implements ItemRestock {
	
	

	@Override
	public String restockItem(Item item, int quantity) {
		String result = "Adding " + quantity + " units to " + item.getProductName();
		System.out.println(result);
		return result;
	}

	@Override
	public Boolean canRestock(Item item) {

		boolean canRestock = Math.random() > 0.5;
		
		if(canRestock) System.out.println("Yes");
		else System.out.println("No");
		
		return canRestock;
	}

	@Override
	public String discontinueItem(Item item) {
		String results = item.getProductName() + " is now no longer available";
		
		return results;
	}

}
