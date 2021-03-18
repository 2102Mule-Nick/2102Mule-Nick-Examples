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
	public void setJdbcdTemplate(JdbcTemplate jdbcdTemplate) {
		this.jdbcTemplate = jdbcdTemplate;
	}

	@Override
	public Item getByName(String itemName) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM item WHERE item_name = ?";
		
		List<Item> itemList = jdbcTemplate.query(sql, itemRowMapper, itemName);
		
		return itemList.get(0);
		
	}

}
