package com.revature.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.pojo.PurchaseOrder;

@Repository
public class PurchaseOrderDaoJDBCTemplate implements PurchaseOrderDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public PurchaseOrder getPurchaseOrderById(int purchaseOrderId) {

		String sql = "select * from purchase_order where purchase_order_id = ?";

		return jdbcTemplate.queryForObject(sql, (rs, row) -> new PurchaseOrder(rs.getInt("purchase_order_id"),
				rs.getInt("cart_id"), rs.getString("purchase_date")), purchaseOrderId);
	}

}
