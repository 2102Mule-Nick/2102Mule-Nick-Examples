package com.revature.service;

import com.revature.exception.OutOfStockException;
import com.revature.pojo.Cart;
import com.revature.pojo.Item;

public interface ShoppingCartService {
	
	public void addItem(Item item, int quantity, Cart cart) throws OutOfStockException;
	
	public void removeItem(int productId, Cart cart);
	
	public float getTotal(Cart cart);
	
	public Cart createCart(Cart cart);

}
