package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	@Override
	public PurchaseOrder createPurchaseOrder(String date, int cartId) {
		
		String sql = "insert into purchase_order (purchase_date, cart_id) values (?, ?)";
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, date);
			ps.setInt(2, cartId);
			return ps;
		}, keyHolder);

		purchaseOrder.setPurchaseOrderId((int) keyHolder.getKeys().get("cart_id"));
		purchaseOrder.setDate(date);
		purchaseOrder.setCartId(cartId);
		
		return purchaseOrder;
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrdersByUserId(int userId) {
		
		String sql = "select po.purchase_order_id , po.purchase_date , po.cart_id from purchase_order po"
				+ "	inner join cart c on po.cart_id = c.cart_id"
				+ "	inner join user_acc ua on c.user_id = ua.user_id"
				+ "	where ua.user_id = ?";
		
		return jdbcTemplate.query(sql, (rs, row) -> new PurchaseOrder(rs.getInt("purchase_order_id"),
				rs.getInt("cart_id"), rs.getString("purchase_date")), userId);

	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		
		String sql = "select * from purchase_order";
		
		return jdbcTemplate.query(sql, (rs, row) -> new PurchaseOrder(rs.getInt("purchase_order_id"),
				rs.getInt("cart_id"), rs.getString("purchase_date")));
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrdersByDate(String date) {
		
		String sql = "select * from purchase_order where purchase_date = ?";
		
		return jdbcTemplate.query(sql, (rs, row) -> new PurchaseOrder(rs.getInt("purchase_order_id"),
				rs.getInt("cart_id"), rs.getString("purchase_date")), date);
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrdersByDateAndUserId(String date, int userId) {
		
		String sql = "select po.purchase_order_id , po.purchase_date , po.cart_id from purchase_order po"
				+ "	inner join cart c on po.cart_id = c.cart_id"
				+ "	inner join user_acc ua on c.user_id = ua.user_id"
				+ "	where ua.user_id = ? and po.purchase_date =?";
		
		return jdbcTemplate.query(sql, (rs, row) -> new PurchaseOrder(rs.getInt("purchase_order_id"),
				rs.getInt("cart_id"), rs.getString("purchase_date")), userId, date);
	}

}
