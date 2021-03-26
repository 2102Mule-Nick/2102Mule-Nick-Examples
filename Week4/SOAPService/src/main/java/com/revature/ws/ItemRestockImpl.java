package com.revature.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pojo.Item;
import com.revature.service.ItemRestockService;

@Service
public class ItemRestockImpl implements ItemRestock {
	
	private ItemRestockService itemRestockService;
	
	@Autowired
	public void setItemRestockService(ItemRestockService itemRestockService) {
		this.itemRestockService = itemRestockService;
	}

	@Override
	public String restockItem(Item item, int quantity) {
		return itemRestockService.restockItem(item, quantity);
	}

	@Override
	public Boolean canRestock(Item item) {
		return itemRestockService.canRestock(item);
	}

	@Override
	public String discontinueItem(Item item) {
		return itemRestockService.discontinueItem(item);
	}

}
