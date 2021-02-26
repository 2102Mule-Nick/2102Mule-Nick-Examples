package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.revature.pojo.Cart;
import com.revature.pojo.Item;

class CartTests {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void addTestEmptyCart() {
		final Cart cart = new Cart();
		final Item item = new Item();
		final int quantity = 3;
		cart.addItem(item, quantity);
		//should update items, total, and quantity
		boolean itemsEquals = cart.getItems().get(0) == item;
		boolean totalEquals = cart.getTotal() == item.getCost();
		boolean quantityEquals = cart.getQuantity().get(0) ==  quantity;
		assertTrue(itemsEquals && totalEquals && totalEquals);
	}
	
	@Test
	public void removeTestLastItem() {
		final Item item = new Item(99, 5.55f, "hat", 1, 0.0f);
		final List<Item> ItemList = new ArrayList<Item>();
		final List<Integer> quantity = new ArrayList<Integer>();
		ItemList.add(item);
		quantity.add(1);
		final Cart cart = new Cart(0, ItemList, 5.55f, quantity);
		cart.removeItem(99,1);
		boolean itemsEquals = cart.getItems().isEmpty();
		boolean totalEquals = cart.getTotal() == 0.0f;
		boolean quantityEquals = cart.getQuantity().isEmpty();
		assertTrue(itemsEquals && totalEquals && totalEquals);
	}
	
//	@Test
//	public void removeItemButNotAll() {
//		final Item item = new Item(99, 5.55f, "hat", 1, 0.0f);
//		final List<Item> ItemList = new ArrayList<Item>();
//		final List<Integer> quantity = new ArrayList<Integer>();
//		ItemList.add(item);
//		quantity.add(1);
//		final Cart cart = new Cart(0, ItemList, 5.55f, quantity);
//		cart.removeItem(99,1);
//		boolean itemsEquals = cart.getItems().isEmpty();
//		boolean totalEquals = cart.getTotal() == 0.0f;
//		boolean quantityEquals = cart.getQuantity().isEmpty();
//		assertTrue(itemsEquals && totalEquals && totalEquals);
//	}

}
