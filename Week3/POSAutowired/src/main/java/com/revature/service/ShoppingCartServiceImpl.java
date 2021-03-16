package com.revature.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.ItemInventory;
import com.revature.exception.OutOfStockException;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Cart;
import com.revature.pojo.Item;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	
	private JmsMessageSender messageSender;


	@Autowired
	public void setMessageSender(JmsMessageSender messageSender) {
		this.messageSender = messageSender;
	}
	
	@Override
	public void addItem(int productId, int quantity, Cart cart) throws OutOfStockException {
		

		Item item = ItemInventory.getItemByProductId(productId);
		
		messageSender.simpleSend("Item added to the cart " + item.getItemName());
		
		if (quantity > item.getQuantity()) {
			throw new OutOfStockException("Quantity does not meet purchase requirements");
		}
		
		List<Item> itemList = cart.getItems();
		itemList.add(item);
		cart.getQuantity().add(quantity);
		item.setQuantity(item.getQuantity()-quantity);
		float itemCost = calculateItemTotal(item, quantity);
		cart.setTotal(itemCost + cart.getTotal());
		
	}

	@Override
	public void removeItem(int productId, Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getTotal(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private float calculateItemTotal(Item item, int quantity) {
		
		float itemCost = item.getCost();
		itemCost -= (item.getDiscount() * itemCost)/100;
		return quantity * itemCost;
	}

	
	
}
