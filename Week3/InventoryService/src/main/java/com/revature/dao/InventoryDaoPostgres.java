package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.pojo.Item;

@Component
public class InventoryDaoPostgres implements InventoryDao {

	private Connection conn;

	@Autowired
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void updateQuantity(Item item, int quantity) {

		String sql = "update item set remining_items = remining_items - ? where product_id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, item.getProductId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
