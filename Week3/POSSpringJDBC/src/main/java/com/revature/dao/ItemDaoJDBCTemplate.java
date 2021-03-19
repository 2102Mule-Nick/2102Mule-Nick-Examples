package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.ItemRowMapper;
import com.revature.pojo.Item;

@Repository
public class ItemDaoJDBCTemplate implements ItemDao {

	private JdbcTemplate jdbcTemplate;
	
	private ItemRowMapper itemRowMapper;
	
	

	@Autowired
	public void setItemRowMapper(ItemRowMapper itemRowMapper) {
		this.itemRowMapper = itemRowMapper;
	}



	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public Item getByName(String itemName) {
		String sql = "select * from item where item_name = ?";

		
		List<Item> itemList = jdbcTemplate.query(sql, itemRowMapper, itemName);
		
		return itemList.get(0);
	}


}
