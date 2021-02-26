package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ItemInventory;
import com.revature.pojo.Cart;
import com.revature.pojo.Item;

import org.junit.jupiter.api.Test;

class UnitTests {

	/*******************************************************************
	 * Items 
	 ******************************************************************/
	private static final Item item = new Item();
	
	@Test
	void itemDefault() {
		assertEquals(1, item.getProductId());
		assertEquals(3.0f, item.getCost());
		assertEquals("default-item-name", item.getItemName());
		assertEquals(1, item.getQuantity());
		assertEquals(0.f, item.getDiscount());
	}

	/*******************************************************************
	 * Cart
	 ******************************************************************/
	private static final Cart cart = new Cart();
	
	@Test
	void cartTotal() {
		cart.setTotal(20.0f);
		assertEquals(20.0f, cart.getTotal());
	}


	@Test
	void cartCartId() {
		cart.setCartId(1);
		assertEquals(1, cart.getCartId());
	}


	@Test
	void cartQuantity() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		cart.setQuantity(list);
		assertEquals(list, cart.getQuantity());
	}

	@Test
	void cartItemsTest() {
		List<Item> item = new ArrayList<>();
		cart.setItems(item);
		assertEquals(item, cart.getItems());
	}
	

	
	
	/*******************************************************************
	 * ItemInventory 
	 ******************************************************************/
//	private final static ItemInventory itemInventory= new ItemInventory();
//
//	@Test
//	void itemInventory() {
//		itemInventory.setInventoryName(null);
//	}
}
