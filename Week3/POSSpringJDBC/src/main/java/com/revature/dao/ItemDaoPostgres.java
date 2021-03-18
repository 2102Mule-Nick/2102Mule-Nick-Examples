package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.pojo.Item;


public class ItemDaoPostgres implements ItemDao {

	private Connection conn;

	//@Autowired
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Item getByName(String itemName) {

		Item item = null;

		String sql = "select * from item where item_name = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, itemName);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				item = new Item();
				item.setItemName(rs.getString("item_name"));
				item.setProductId(rs.getInt("product_id"));
				item.setQuantity(rs.getInt("remining_items"));
				item.setCost(rs.getFloat("item_cost"));
				item.setDiscount(rs.getFloat("discount"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

}
