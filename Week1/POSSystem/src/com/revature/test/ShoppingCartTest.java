package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.dao.ItemInventory;
import com.revature.exception.OutOfStockException;
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

	private static Item item;
	
	private static ShoppingCartServiceImpl service;
	
	@BeforeEach
	private void setUp() {
		item = new Item(1, 1.0f, "milk", 1, 0.0f);
		ItemInventory.addItem(item);
		service = new ShoppingCartServiceImpl();
	}
	
	@AfterEach
	private void tearDown() {
		ItemInventory.getItemList().clear();
		item = null;
	}
	
	@Test
	void getItemsEmptyCart() {
	}
	
	@Test
	void viewTotalOfCart() {
		
	}
	
	@Test
	void getCartById() {
		
	}
	
	@Test
	void itemIsAddedToCart() throws OutOfStockException {
		
		//AAA Pattern for testing
		
		//Arrange
		Cart cart = new Cart();
		
		//Act
		service.addItem(1, 1, cart);
		
		//Assert
		assertEquals("Cart should have 1 item in it", 1, cart.getItems().size());
		
	}
	
	@Test
	void addMoreItemsThanQuantity() {
		
		//Arrange
		Cart cart = new Cart();
		
		//Act
		assertThrows(OutOfStockException.class, () -> {service.addItem(1, 5, cart);});
		
		//Assert
		assertEquals("Make sure no items were added", 0, cart.getItems().size());
		
	}
	
	@Test
	void itemIsRemovedFromCart() {
		
	}

}
