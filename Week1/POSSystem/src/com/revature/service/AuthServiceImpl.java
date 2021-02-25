package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;

public class AuthServiceImpl implements AuthService {
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean existingUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User authenticateUser(User user) throws InvalidPassword, UserNotFound {
		
		User existingUser = userDao.getUserByUsername(user.getUsername());
		
		if (existingUser.getPassword().equals(user.getPassword())) {
			return existingUser;
		}
		
		throw new InvalidPassword();
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
