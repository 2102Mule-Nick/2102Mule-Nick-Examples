package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.UserRowMapper;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;

@Repository
public class UserDaoJDBCTemplate implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	private UserRowMapper userRowMapper;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public void setUserRowMapper(UserRowMapper userRowMapper) {
		this.userRowMapper = userRowMapper;
	}



	@Override
	public void createUser(User user) throws UserNameTaken {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByUsername(String username) throws UserNotFound {
		
		String sql = "select * from user_acc where username = ?";

		//Object[] args = new Object[] {username};
		
		List<User> userList = jdbcTemplate.query(sql, userRowMapper, username);
		
		return userList.get(0);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user, String new_password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub

	}

}
