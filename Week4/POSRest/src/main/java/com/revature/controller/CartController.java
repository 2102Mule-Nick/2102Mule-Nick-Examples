package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dto.ItemInventory;
import com.revature.exception.OutOfStockException;
import com.revature.pojo.Cart;
import com.revature.pojo.Item;
import com.revature.service.ShoppingCartService;

@Controller
public class CartController {
	
	private ShoppingCartService shoppingCartService;
	
	
	@Autowired
	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}



	//@GetMapping("/cart")
	@RequestMapping(path = "/cart", method = RequestMethod.GET)
	@ResponseBody
	public List<Cart> getAllCarts(){
		return shoppingCartService.getAllCarts();
	}
	
	@GetMapping("/cart/{id}")
	@ResponseBody
	public Cart getCartById(@PathVariable(name = "id") String id){
		
		int idInteger = Integer.parseInt(id);
		
	 	return shoppingCartService.getCartById(idInteger);
	}
	
	@DeleteMapping("/cart/{id}")
	@ResponseBody
	public void deleteCartById(@PathVariable(name = "id") String id){
		
		int idInteger = Integer.parseInt(id);
		
	 	shoppingCartService.deleteCartById(idInteger);
	}
	
	@PostMapping(path = "/cart")
	@ResponseBody
	public ResponseEntity<String> createCart(@RequestBody Cart cart) {
		
		System.out.println(cart);
		
		if (cart.getItems().size() > 0 || cart.getQuantity().size() > 0) {
			
			return ResponseEntity.badRequest().body("Can only create empty cart. Please remove items and try again");
			
		}
		
		Cart createdCart = shoppingCartService.createCart(cart);
		
		return ResponseEntity.ok("Item inserted successfully! Cart id: " + createdCart.getCartId());
		
		
		
	}
	
	@PutMapping(path = "/cart")
	@ResponseBody
	public String updateCart(@RequestBody Cart cart) {
		
		shoppingCartService.updateCart(cart);
		
		return "Item updated successfully!";
	}
	
	@PostMapping(path = "/cart/{cartId}/item")
	public ResponseEntity<Cart> addItemToCart(@PathVariable int cartId, @RequestBody ItemInventory itemInventory) {
		
		try {
			
			Cart cart = shoppingCartService.getCartById(cartId);
			
			if (cart == null) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(shoppingCartService.addItem(itemInventory.getItem(), itemInventory.getQuantity(), cart));
		} catch (OutOfStockException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
