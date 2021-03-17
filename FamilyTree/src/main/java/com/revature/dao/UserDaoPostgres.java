package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactoryPostgres;

public class UserDaoPostgres implements UserDao {
	
	Logger log = Logger.getRootLogger();

	@Override
	public void createUser(User user) throws UserNameTaken {
		
		log.trace("UserDaoPostgres.createUser method called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "insert into family_tree (father_name, mother_name, first_name, last_name) values ('" + user.getUsername() + "', '" +user.getPassword() + "', '" + user.getFirstname() + "', '" + user.getLastname() + "')";
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUserByUsername(String father_name) throws UserNotFound {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}

		User user = null;
		
		String url = "jdbc:postgresql://" + System.getenv("POS_DB_URL") + ":5432/" + "postgres" + "?";
		
		String usr = System.getenv("POS_DB_USERNAME");
		
		String password = System.getenv("POS_DB_PASSWORD");
		
		//log.info("usr : " + usr);
		//log.info("password : " + password);
		
		try (Connection conn = DriverManager.getConnection(url, usr, password);) {
			
			//conn.setSchema(schema);
			
			String sql = "select * from family_tree where father_name = '" + father_name + "'";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				log.info("User found in DB");
				user = new User();
				user.setUsername(rs.getString("father_name"));
				user.setPassword(rs.getString("mother_name"));
				user.setFirstname(rs.getString("first_name"));
				user.setLastname(rs.getString("last_name"));
			}
			
		} catch (SQLException e) {
			log.error("Failure to connect to DB", e);
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user, String new_mother_name, String new_father_name, String new_lastname) {
		// TODO Auto-generated method stub

		Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "update family_tree set mother_name = ?, father_name = ? WHERE first_name = ? and last_name = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, new_mother_name);
			stmt.setString(2, new_father_name);
			stmt.setString(3, user.getFirstname());
			stmt.setString(4, user.getLastname());
			stmt.executeUpdate();
			log.info("User updated");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Unsuccessful update");
		}
		
	}

	@Override
	public void deleteUser(User user) {

		log.trace("UserDaoPostgres.createUser method called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "delete from family_tree where father_name = ? and mother_name = ?";
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
