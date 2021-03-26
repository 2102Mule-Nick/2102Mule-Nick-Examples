package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.ItemRestockDao;
import com.revature.pojo.Item;

@Component
public class ItemRestockServiceImpl implements ItemRestockService {
	
	private ItemRestockDao itemRestockDao;
	
	@Autowired
	public void setItemRestockDao(ItemRestockDao itemRestockDao) {
		this.itemRestockDao = itemRestockDao;
	}

	@Override
	public String restockItem(Item item, int quantity) {
		
		if (!canRestock(item)) {
			return "Item " + item.getProductName() + " is discontinued and cannot be restocked";
		}
		
		if (itemRestockDao.updateItemQuantity(item.getProductId(), quantity)) {
			return "item " + item.getProductName() + " succesfully updated quantity by " + quantity;
		}
		
		return "Item " + item.getProductName() + " quantity has not been updated";
		
	}

	@Override
	public Boolean canRestock(Item item) {
	
		return itemRestockDao.canRestock(item);

	}

	@Override
	public String discontinueItem(Item item) {

		if (itemRestockDao.updateItemStatus(item.getProductId(), true)) {
			return "Item " + item.getProductName() + " is discontinued";
		}
		
		return "Item " + item.getProductName() + " is not discontinued";
	
	}

}
