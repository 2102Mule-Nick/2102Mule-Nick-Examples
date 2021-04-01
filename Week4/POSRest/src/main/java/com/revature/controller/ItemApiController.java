package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/getallitems")
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
	
	@GetMapping("/getoneitem/")
	@ResponseBody
	public Item getOneItem(@RequestHeader String name) { //changed from @RequestBody to @RequestHeader
		
		System.out.println("item name: " + name);
		
		Item item = itemDao.getByName(name);
		
		return item;
	}
	
	@PutMapping("/updateoneitem")
	@ResponseBody
	public String updateOneItem(@RequestBody Item item) {
		System.out.println("Updating item");
		
		itemDao.updateItem(item);
		
		return "Item update successfully";
	}
	
	@DeleteMapping("/deleteoneitem")
	@ResponseBody
	public String deleteOneItme(@RequestBody Item item) {
		
		itemDao.removeItem(item);
		
		return "Item removed from inventory";
	}
	
	@PutMapping("/createitem")
	@ResponseBody
	public String createItem(@RequestBody Item item) {
		itemDao.addItem(item);
		
		return "Item added to inventory";
	}
}
