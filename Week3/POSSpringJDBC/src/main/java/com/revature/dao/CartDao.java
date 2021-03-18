package com.revature.dao;

import java.sql.SQLException;

import com.revature.pojo.Cart;
import com.revature.pojo.Item;

public interface CartDao {
	
	public Cart createCart(Cart cart) throws SQLException;
	
	public Cart getCartById(int id);
	
	public void deleteCart(int id);
	
	public void updateCart(Cart cart);
	
	public Cart addItemToCart(Cart cart, Item item, int quantity);
	
	public Cart removeItemFromCart(Cart cart, Item item);

}
