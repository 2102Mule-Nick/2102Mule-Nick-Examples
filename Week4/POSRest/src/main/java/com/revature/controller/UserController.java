package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.UserDaoJDBCTemplate;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.PurchaseOrder;
import com.revature.pojo.User;
import com.revature.service.PurchaseOrderServiceFinder;

@Controller
public class UserController {

	private UserDaoJDBCTemplate userDaoJdbc;
	
	private PurchaseOrderServiceFinder purchaseOrderService;

	@Autowired
	public void setUserDaoJdbc(UserDaoJDBCTemplate userDaoJdbc) {
		this.userDaoJdbc = userDaoJdbc;
	}
	
	@Autowired
	public void setPurchaseOrderService(PurchaseOrderServiceFinder purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
	
	@GetMapping("/user/purchase/{purchaseId}")
	@ResponseBody
	public PurchaseOrder getPurchaseOrder(@PathVariable int purchaseId) {
		return purchaseOrderService.getPurchaseOrder(purchaseId);
	}
	


	@GetMapping("/user")
	@ResponseBody
	public List<User> getUsers() {

		return userDaoJdbc.getAllUsers();

	}
	@GetMapping("/user/{username}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		try {
			return ResponseEntity.ok(userDaoJdbc.getUserByUsername(username));
		} catch (UserNotFound e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(path = "/get-user")
	@ResponseBody
	public void updateUser(@RequestBody User user) {
		System.out.println(user);
		userDaoJdbc.updateUser(user, user.getPassword());
	}
	@PostMapping("/create-user")
	@ResponseBody
	public String createNewUser(@RequestBody User user) {
		
		try {
			
			userDaoJdbc.createUser(user);
			return "New User created";
		} catch (UserNameTaken e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Something happened";
	}
	
	@DeleteMapping("/delete-user")
	@ResponseBody
	public String deleteUser(@RequestBody User user) {
		
		if(userDaoJdbc.removeUser(user))
			{
			return "User Deleted";
			}
		return "User Not deleted";
	}
	
	@PutMapping("/get-user-test")
	@ResponseBody
	public User getUserTest(@RequestBody String username) {
		try {
			
			User user = userDaoJdbc.getUserByUsername(username);
			System.out.println(user);
			return user;
			
		} catch (UserNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
		
}
