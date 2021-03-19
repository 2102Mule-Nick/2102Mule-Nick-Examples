package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	public void setCartRowMapper(CartRowMapper cartRowMapper) {
		this.cartRowMapper = cartRowMapper;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public Cart createCart(Cart cart) throws SQLException {
		
		String sql = "insert into cart (user_id, total) values(?, ?)";
		KeyHolder holder = new GeneratedKeyHolder();	
		
		jdbcTemplate.update( connection -> {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "cart_id" });
				ps.setInt(1, cart.getUserId());
				ps.setFloat(2, cart.getTotal());
				return ps;
			
		}, holder);
		
		int cartId = holder.getKey().intValue();
		
		//System.out.println(cartId);
		String sql1 = "select * from cart where cart_id = ?";

		List<Cart> cartList = jdbcTemplate.query(sql1, cartRowMapper, cartId);
		
		return cartList.get(0);
	}

	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCart(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cart addItemToCart(Cart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart removeItemFromCart(Cart cart, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

}
