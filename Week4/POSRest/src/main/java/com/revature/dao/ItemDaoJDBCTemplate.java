package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	@Override
	public List<Item> getAllItems() {
		String sql = "SELECT * FROM item";
		
		List<Item> itemList = jdbcTemplate.query(sql, itemRowMapper);
		
		return itemList;
	}

	@Override
	public void updateItem(Item item) {
		String sql = "UPDATE item SET item_cost = ?, item_name = ?, remaining_items = ?, discount = ? "
				+ "WHERE product_id = ?";
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setFloat(1, item.getCost());
			ps.setString(2, item.getItemName());
			ps.setInt(3, item.getQuantity());
			ps.setFloat(4, item.getDiscount());
			ps.setInt(5, item.getProductId());
			return ps;
		});
		
	}

	@Override
	public void removeItem(Item item) {
		String sql = "UPDATE item SET discontinue = TRUE WHERE product_id = ?";
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, item.getProductId());
			return ps;
		});
	}

	@Override
	public void addItem(Item item) {
		String sql = "INSERT INTO item (item_name, item_cost, remining_items, discount, discontinue)"
				+ "VALUES (?, ?, ?, ?, False)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, item.getItemName());
			ps.setFloat(2, item.getCost());
			ps.setInt(3, item.getQuantity());
			ps.setFloat(4, item.getDiscount());
			return ps;
		}, keyHolder);
		
		item.setProductId((int) keyHolder.getKeys().get("product_id"));
		
	}

}
