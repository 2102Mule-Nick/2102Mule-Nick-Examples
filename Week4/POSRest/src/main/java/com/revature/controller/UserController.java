package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoJDBCTemplate;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Item;
import com.revature.pojo.User;

@Controller
public class UserController {

	private UserDaoJDBCTemplate userDaoJdbc;
	

	@Autowired
	public void setUserDaoJdbc(UserDaoJDBCTemplate userDaoJdbc) {
		this.userDaoJdbc = userDaoJdbc;
	}

	@GetMapping("/get-all-users")
	@ResponseBody
	public List<User> getUsers() {

		return userDaoJdbc.getAllUsers();

	}
	@GetMapping("/get-user")
	@ResponseBody
	public User getUser() {
		try {
			return userDaoJdbc.getUserByUsername("divyesh");
		} catch (UserNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
