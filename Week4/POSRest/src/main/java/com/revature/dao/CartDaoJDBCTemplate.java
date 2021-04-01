package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.CartRowMapper;
import com.revature.pojo.Cart;
import com.revature.pojo.Item;

@Repository
public class CartDaoJDBCTemplate implements CartDao {

	private JdbcTemplate jdbcTemplate;

	private CartRowMapper cartRowMapper;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setCartRowMapper(CartRowMapper cartRowMapper) {
		this.cartRowMapper = cartRowMapper;
	}
	


	@Override
	public Cart createCart(Cart cart) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into cart (user_id, total) values(?, ?)";

		/*
		 * Object[] args = new Object[] {cart.getUserId(), cart.getTotal()};
		 * 
		 * int newCart = jdbcTemplate.update(sql, args);
		 */
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, cart.getUserId());
			ps.setFloat(2, cart.getTotal());
			return ps;
		}, keyHolder);

		cart.setCartId((int) keyHolder.getKeys().get("cart_id"));

		return cart;
	}

	@Override
	public Cart getCartById(int id) {
		
		String sql = "select * from cart where cart_id = ?";
		
		List<Cart> cartList = jdbcTemplate.query(sql, cartRowMapper, id);
		
		System.out.println(cartList);
		
		return cartList.get(0);
	}

	@Override
	public void deleteCart(int id) {

		String sql = "delete from cart where cart_id = ?";
		
		jdbcTemplate.update(sql, id);

	}

	@Override
	public void updateCart(Cart cart) {
		
		String sql = "update cart set total = ? where cart_id = ?";
		
		jdbcTemplate.update(sql,cart.getTotal(), cart.getCartId());
		
	}

	@Override
	public Cart addItemToCart(Cart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
		String sql = "insert into cart_item values(?, ?, ?)";

		Object[] args = new Object[] { cart.getCartId(), item.getProductId(), quantity };

		// jdbcTemplate.update(sql, cartRowMapper, cart.getCartId(),
		// item.getProductId(), quantity);

		jdbcTemplate.update(sql, args);

		return cart;

	}

	@Override
	public Cart removeItemFromCart(Cart cart, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getAllCart() {

		String sql = "select * from cart";
		
		List<Cart> cartList = jdbcTemplate.query(sql,cartRowMapper);
		
		return cartList;
	}

}
