package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.revature.pojo.Cart;
import com.revature.pojo.Item;
import com.revature.service.ShoppingCartService;
import com.revature.service.ShoppingCartServiceImpl;

/*
 * Add Item to shopping cart
 * Remove Item from shopping cart
 * get total of cart
 * update quantity of item
 * get items in cart
 */
class ShoppingCartTest {

	@Test
	void getItemsEmptyCart() {
		fail("Not yet implemented");
	}
	
	@Test
	void viewTotalOfCart() {
		
	}
	
	@Test
	void getCartById() {
		
	}
	
	@Test
	void itemIsAddedToCart() {
		
		//AAA Pattern for testing
		
		//Arrange
		Item item = new Item(1, 1.0f, "milk", 1, 0.0f);
		Cart cart = new Cart();
		ShoppingCartServiceImpl service = new ShoppingCartServiceImpl();
		
		//Act
		service.addItem(1, 1, cart);
		
		//Assert
		assertEquals("Cart should have 1 item in it", 1, cart.getItems().size());
		
	}
	
	@Test
	void itemIsRemovedFromCart() {
		
	}

}
