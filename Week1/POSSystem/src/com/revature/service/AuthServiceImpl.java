package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.dao.UserDao;
import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;

public class AuthServiceImpl implements AuthService {
	
	Logger log = Logger.getRootLogger();

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean existingUser(User user) {
		log.trace("AuthServiceImpl.existingUser method called");
		try {
			if (userDao.getUserByUsername(user.getUsername()) != null) {
				log.info("getUserByUsername did not return null");
				return true;
			}
		} catch (UserNotFound e) {
			return false;
		}
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
	public User registerUser(User user) throws UserNameTaken {
		log.trace("AuthServiceImpl.registerUser method called");
		userDao.createUser(user);
		return user;
	}

	public AuthServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

}
