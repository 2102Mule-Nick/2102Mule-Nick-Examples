package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.Item;

@Component
public class ItemRestockExtractor implements ResultSetExtractor<Item> {

	@Override
	public Item extractData(ResultSet rs) throws SQLException, DataAccessException {

		Item item = new Item();
		
		item.setProductId(rs.getInt("product_id"));
		
		item.setProductName(rs.getString("item_name"));
		
		return item;
	}

}
