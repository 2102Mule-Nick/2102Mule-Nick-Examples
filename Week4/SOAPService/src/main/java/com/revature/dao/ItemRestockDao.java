package com.revature.dao;

import com.revature.pojo.Item;

public interface ItemRestockDao {
	
	public boolean canRestock(Item item);
	
	public Item getItemByItemId(int productId);
	
	public boolean updateItemStatus(int itemId, boolean discontinued);
	
	public boolean updateItemQuantity(int itemId, int quantity);

}
