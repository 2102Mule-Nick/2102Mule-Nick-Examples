package com.revature.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;



import com.revature.pojo.Cart;
import com.revature.pojo.Item;

class ShoppingCartTest {

	private final static Cart cartEvaluationService = new Cart();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testSetCartIdLessThanOrEqualZero() {
		
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> {cartEvaluationService.setCartId(2);});

	}
	
	@Test
	public void testSetCartItemNotNull() {
		
		List<Item> items = null;
		expectedException.expect(NullPointerException.class);
		cartEvaluationService.setItems(items);

	}

}
