package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.revature.pojo.Item;

@Component
public class ItemRestockRowMapper implements RowMapper<Item> {

	public ItemRestockExtractor itemRestockExtractor;
	
	@Autowired
	public void setItemRestockExtractor(ItemRestockExtractor itemRestockExtractor) {
		this.itemRestockExtractor = itemRestockExtractor;
	}



	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		return itemRestockExtractor.extractData(rs);
	}

}
