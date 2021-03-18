package com.revature.ui;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.exception.OutOfStockException;
import com.revature.pojo.Cart;
import com.revature.pojo.Item;
import com.revature.service.AuthService;
import com.revature.service.ItemService;
import com.revature.service.ShoppingCartService;

@Component
public class CartMenu implements Menu {
	
	
	private Scanner scan;
	
	private ItemService itemService;
	
	private ShoppingCartService cartService;
	
	private AuthService authService;

	private Menu nextMenu;
	
	private Menu welcomeMenu;
	
	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		
		Cart cart = new Cart(-1, new ArrayList<>(), 0.0f, new ArrayList<>(), authService.getCurrentUser().getUserId());
		
		cart = cartService.createCart(cart);
		
		System.out.println("Please select an option:");
		System.out.println("1: Add Item to Cart");
		System.out.println("2: Delete Item from Cart");
		System.out.println("3: View All Items");
		System.out.println("4: Checkout");
		
		String option = scan.nextLine();
		
		switch (option) {
		
		case "1":
			addItemSelection(cart);
			nextMenu = this;
			break;
		default :
			System.out.println("Not implemented yet....");
			nextMenu = welcomeMenu;
			break;
		}

	}

	@Override
	public Menu previousMenu() {

		return null;
	}

	@Override
	public Scanner getScanner() {
		return scan;
	}

	@Override
	@Autowired
	//@Qualifier("scan2")
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}
	
	@Autowired
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Autowired
	public void setCartService(ShoppingCartService cartService) {
		this.cartService = cartService;
	}
	
	@Autowired
	public void setWelcomeMenu(Menu welcomeMenu) {
		this.welcomeMenu = welcomeMenu;
	}

	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	private void addItemSelection(Cart cart) {
		System.out.println("Please type the item name:");
		String itemName = scan.nextLine();
		System.out.println("How many do you need?");
		int quantity = scan.nextInt();
		Item item = itemService.getItemByItemName(itemName);
		try {
			cartService.addItem(item, quantity, cart);
		} catch (OutOfStockException e) {
			System.out.println("Sorry, item out of stock.");
		}
	}

}
