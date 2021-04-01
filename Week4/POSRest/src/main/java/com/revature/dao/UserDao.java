package com.revature.dao;

import java.util.List;

import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;

public interface UserDao {

	public void createUser(User user) throws UserNameTaken;
	
	public User getUserByUsername(String username) throws UserNotFound;
	
	public List<User> getAllUsers();
	
	public void updateUser(User user, String new_password);
	
	public boolean removeUser(User user);
	
}
