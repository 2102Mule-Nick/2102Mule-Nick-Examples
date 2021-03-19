package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoJDBCTemplate;
import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;

@Component
public class AuthServiceImpl implements AuthService {
	
	Logger log = Logger.getRootLogger();
	
	private User currentUser;

	//@Autowired - field injection (using relfection)
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired //setter injection
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
			this.currentUser = existingUser;
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

	@Autowired //constructor injection
	public AuthServiceImpl(UserDaoJDBCTemplate userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public User updateUser(User user, String password) {
		// TODO Auto-generated method stub
		log.info("Update User in Auth Service called");
		userDao.updateUser(user, password);
		return null;
	}
	
	public boolean removeUser(User user) {

		if (existingUser(user)) {
			userDao.removeUser(user);
			return true;
		}
		return false;
	}

	@Override
	public User getCurrentUser() {
		return currentUser;
	}

}
