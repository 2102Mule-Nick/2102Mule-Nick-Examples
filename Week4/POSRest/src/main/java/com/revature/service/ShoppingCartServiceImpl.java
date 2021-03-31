package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.CartDao;
import com.revature.exception.OutOfStockException;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Cart;
import com.revature.pojo.Item;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private CartDao cartDao;
	
	private JmsMessageSender messageSender;

	@Autowired
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Autowired
	public void setMessageSender(JmsMessageSender messageSender) {
		this.messageSender = messageSender;
	}
	
	@Override
	@Transactional
	public void addItem(Item item, int quantity, Cart cart) throws OutOfStockException {
		
		messageSender.sendToInventoryQueue(item, quantity);
		
		if (quantity > item.getQuantity()) {
			throw new OutOfStockException("Quantity does not meet purchase requirements");
		}
		
		List<Item> itemList = cart.getItems();
		itemList.add(item);
		cart.getQuantity().add(quantity);
		item.setQuantity(item.getQuantity()-quantity);
		float itemCost = calculateItemTotal(item, quantity);
		cart.setTotal(itemCost + cart.getTotal());
		
		cartDao.addItemToCart(cart, item, quantity);
		
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

	@Override
	public Cart createCart(Cart cart) {
		try {
			return cartDao.createCart(cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
}
