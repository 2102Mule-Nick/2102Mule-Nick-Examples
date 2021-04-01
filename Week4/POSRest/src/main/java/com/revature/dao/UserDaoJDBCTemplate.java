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
		String sql = "insert into user_acc(username,pass_word) values (?,?)";
		jdbcTemplate.update(sql, user.getUsername(),user.getPassword());
		

	}

	@Override
	public User getUserByUsername(String username) throws UserNotFound {

		String sql = "select * from user_acc where username = ?";

		// Object[] args = new Object[] {username};

		List<User> userList = jdbcTemplate.query(sql, userRowMapper, username);

		if (userList.size() == 0) {
			throw new UserNotFound();
		}
		
		return userList.get(0);
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "select * from user_acc";

		List<User> usersList = jdbcTemplate.query(sql, userRowMapper);
		return usersList;

	}

	@Override
	public void updateUser(User user, String new_password) {
		String sql = "update user_acc set pass_word= ? where username=?";
		jdbcTemplate.update(sql, new_password, user.getUsername());
		System.out.println("User Updated");
	}

	@Override
	public boolean removeUser(User user) {
	String sql = "delete from user_acc where username =? and pass_word=?";
	if(jdbcTemplate.update(sql, user.getUsername(),user.getPassword())==0) {
		return false;
	}
	return true;

	}

}
