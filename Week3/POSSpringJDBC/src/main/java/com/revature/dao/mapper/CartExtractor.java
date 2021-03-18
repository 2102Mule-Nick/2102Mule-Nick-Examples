package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.Cart;

@Component
public class CartExtractor implements ResultSetExtractor<Cart> {

	@Override
	public Cart extractData(ResultSet rs) throws SQLException, DataAccessException {

		Cart newCart = new Cart();
		
		newCart.setCartId(rs.getInt("cart_id"));
		newCart.setUserId(rs.getInt("user_id"));
		newCart.setTotal(rs.getFloat("total"));
	
		return newCart;
	}

	
}
