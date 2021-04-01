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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.ItemDaoJDBCTemplate;
import com.revature.pojo.Item;

@Controller
public class ItemApiController {
	
	private ItemDaoJDBCTemplate itemDao;
	
	/*
	 * 
	 * 1. get all items
	 * 
	 * 2. get one item
	 * 
	 * 3. update an item
	 * 
	 *  4. delete an item
	 *  
	 *  5. create an item
	 * 
	 * 
	 * 
	 */

	@GetMapping("/item")
	@ResponseBody
	public List<Item> getAllItems() {
		System.out.println("Getting all items");
		
		List<Item> itemList;
		
		itemList = itemDao.getAllItems();
		
		return itemList;
	}

	@Autowired
	public void setItemDao(ItemDaoJDBCTemplate itemDao) {
		this.itemDao = itemDao;
	}
	
	@GetMapping("/item/{name}")
	@ResponseBody
	public Item getOneItem(@PathVariable String name) {//(@RequestHeader String name) { //changed from @RequestBody to @RequestHeader
		
		System.out.println("item name: " + name);
		
		Item item = itemDao.getByName(name);
		
		return item;
	}
	
	@PutMapping("/item")
	@ResponseBody
	public String updateOneItem(@RequestBody Item item) {
		System.out.println("Updating item");
		
		itemDao.updateItem(item);
		
		return "Item update successfully";
	}
	
	@DeleteMapping("/item")
	@ResponseBody
	public String deleteOneItme(@RequestBody Item item) {
		
		itemDao.removeItem(item);
		
		return "Item removed from inventory";
	}
	
	@PostMapping("/item")
	@ResponseBody
	public String createItem(@RequestBody Item item) {
		itemDao.addItem(item);
		
		return "Item added to inventory";
	}
}
