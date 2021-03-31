package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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



	@GetMapping("/cart")
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
	public String createCart(@RequestBody Cart cart) {
		
		shoppingCartService.createCart(cart);
		
		return "Item inserted successfully!";
	}
	
	@PutMapping(path = "/cart")
	@ResponseBody
	public String updateCart(@RequestBody Cart cart) {
		
		shoppingCartService.updateCart(cart);
		
		return "Item updated successfully!";
	}
	
}
