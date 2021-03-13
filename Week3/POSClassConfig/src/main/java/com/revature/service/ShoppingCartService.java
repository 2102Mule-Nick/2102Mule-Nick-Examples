package com.revature.service;

import com.revature.exception.OutOfStockException;
import com.revature.pojo.Cart;

public interface ShoppingCartService {
	
	public void addItem(int productId, int quantity, Cart cart) throws OutOfStockException;
	
	public void removeItem(int productId, Cart cart);
	
	public float getTotal(Cart cart);

}
