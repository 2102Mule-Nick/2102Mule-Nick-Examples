package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.pojo.Cart;
import com.revature.pojo.Item;

public class CartDaoPostgres implements CartDao {
	
	private Connection conn;

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
	public Cart addItemToCart(Cart cart, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart removeItemFromCart(Cart cart, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart createCart(Cart cart) throws SQLException {
		/*
		 * String sql = "insert into cart (user_id, total) values(?, ?)"; int[] ids =
		 * new int[1]; PreparedStatement pstmt = conn.prepareStatement(sql, ids);
		 * pstmt.setInt(1, cart.getUserId()); pstmt.setFloat(2, cart.getTotal());
		 * pstmt.executeUpdate(); cart.setCartId(ids[0]);
		 */
		return cart;
	}

}
