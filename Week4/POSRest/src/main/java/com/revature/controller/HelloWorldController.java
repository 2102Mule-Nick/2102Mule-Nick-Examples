package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.ItemDaoJDBCTemplate;
import com.revature.pojo.Item;

@Controller
public class HelloWorldController {

	@GetMapping("/hello")
	@ResponseBody
	public String helloWorld() {
		return "hello world!";
	}
	
	@GetMapping("/test-item")
	@ResponseBody
	public Item getItem() {
		
		return new Item(55, 5.0f, "egg", 2000, 0.0f);
		
	}
	
	@PutMapping(path = "/test-item")
	@ResponseBody
	public String updateItem(@RequestBody Item item) {
		
		System.out.println(item);
		
		return "Item updated";
	}
	
		
}
