package com.revature.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Item;

@Repository
public class ItemRestockDaoPostgres implements ItemRestockDao {

	public JdbcTemplate jdbcTemplate;

	public ItemRestockRowMapper itemRestockRowMapper;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setItemRestockRowMapper(ItemRestockRowMapper itemRestockRowMapper) {
		this.itemRestockRowMapper = itemRestockRowMapper;
	}

	@Override
	public boolean canRestock(Item item) {
		String sql = "select discontinued from item where product_id = ?";

		Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql, item.getProductId());

		Boolean discontinued = (Boolean) resultMap.get("discontinued");
		
		return !discontinued;
	}

	@Override
	public Item getItemByItemId(int productId) {

		String sql = "select * from item where product_id = ?";

		// List<Item> item = jdbcTemplate.query(sql, itemRestockRowMapper, productId);

		return jdbcTemplate.queryForObject(sql, itemRestockRowMapper, productId);

		// return item.get(0);
	}

	@Override
	public boolean updateItemStatus(int itemId, boolean discontinued) {

		String sql = "update item set discontinued = ? where product_id = ?";

		if (jdbcTemplate.update(sql, discontinued, itemId) == 0) {
			return false;
		}

		return true;
	}

	@Override
	public boolean updateItemQuantity(int itemId, int quantity) {

		String sql = "update item set quantity = ? where product_id = ?";

		if (jdbcTemplate.update(sql, quantity, itemId) == 0) {
			return false;
		}

		return true;
	}

}
