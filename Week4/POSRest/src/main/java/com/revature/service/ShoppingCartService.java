package com.revature.service;

import java.util.List;

import com.revature.exception.OutOfStockException;
import com.revature.pojo.Cart;
import com.revature.pojo.Item;

public interface ShoppingCartService {
	
	public void addItem(Item item, int quantity, Cart cart) throws OutOfStockException;
	
	public void removeItem(int productId, Cart cart);
	
	public float getTotal(Cart cart);
	
	public Cart createCart(Cart cart);
	
	public List<Cart> getAllCarts();
	
	public Cart getCartById(int id);
	
	public void deleteCartById(int id);
	
	public void updateCart(Cart cart);

}
