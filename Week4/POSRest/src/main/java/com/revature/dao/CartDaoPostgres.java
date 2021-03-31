package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.pojo.Cart;
import com.revature.pojo.Item;


public class CartDaoPostgres implements CartDao {

	private Connection conn;

	//@Autowired
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCart(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cart addItemToCart(Cart cart, Item item, int quantity) {
		String sql = "insert into cart_item values(?, ?, ?)";

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cart.getCartId());
			pstmt.setInt(2, item.getProductId());
			pstmt.setInt(3, quantity);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cart;
	}

	@Override
	public Cart removeItemFromCart(Cart cart, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart createCart(Cart cart) throws SQLException {

		String sql = "insert into cart (user_id, total) values(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, cart.getUserId());
		pstmt.setFloat(2, cart.getTotal());
		pstmt.executeUpdate();

		// grab generated cart_id
		ResultSet rs = pstmt.getGeneratedKeys();
		rs.next();
		cart.setCartId((int) rs.getLong(1));

		return cart;
	}

}
