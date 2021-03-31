package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.revature.pojo.User;

@Component
public class UserRowMapper implements RowMapper<User> {

	private UserExtractor userExtractor;
	
	@Autowired
	public void setUserExtractor(UserExtractor userExtractor) {
		this.userExtractor = userExtractor;
	}



	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return userExtractor.extractData(rs);
	}

}
