package com.revature.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.dao.CartDaoPostgres;
import com.revature.pojo.Cart;
import com.revature.util.ConnectionFactoryPostgres;

@RunWith(MockitoJUnitRunner.class)
class CartDaoTest {
	
	@Mock
	private Connection connection;
	
	CartDaoPostgres daoPostgres;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		daoPostgres = new CartDaoPostgres();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void createCartTest() throws SQLException {
		
		String sql = "insert into cart (user_id, total) values(?, ?)";
		
		Connection realConnection = ConnectionFactoryPostgres.getConnection();
		
		System.out.println(realConnection);
		
		PreparedStatement realStmt = realConnection.prepareStatement(sql);
		
		PreparedStatement spy = Mockito.spy(realStmt);
		
		System.out.println("Spy" + spy);
		
		System.out.println("Conn Mock" + connection);
		
		when(connection.prepareStatement(sql)).thenReturn(spy);
		
		daoPostgres.setConn(connection);
		
		Cart cart = new Cart();
		
		cart.setTotal(0.0f);
		
		cart.setUserId(30);
		
		daoPostgres.createCart(cart);
		
		verify(spy).setInt(1, cart.getUserId());
		
		verify(spy).setFloat(2, cart.getTotal());
		
		verify(spy).executeUpdate();
		
		PreparedStatement checkStmt = ConnectionFactoryPostgres.getConnection().prepareStatement("select * from cart where user_id = 30");
		
		ResultSet rs = checkStmt.executeQuery();
		
		assertTrue(rs.next());
		
		
	}

}
