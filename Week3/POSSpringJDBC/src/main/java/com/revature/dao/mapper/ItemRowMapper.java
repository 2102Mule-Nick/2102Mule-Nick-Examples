package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.revature.pojo.Item;

@Component
public class ItemRowMapper implements RowMapper<Item> {

	private ItemExtractor itemExtractor;
	
	
	@Autowired
	public void setItemExtractor(ItemExtractor itemExtractor) {
		this.itemExtractor = itemExtractor;
	}



	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return itemExtractor.extractData(rs);
	}

}
