package com.revature.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.dao.CartDaoPostgres;
import com.revature.pojo.Cart;
import com.revature.util.ConnectionFactoryPostgres;

@ExtendWith(MockitoExtension.class)
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
		
		PreparedStatement pstmt = ConnectionFactoryPostgres.getConnection().prepareStatement("delete from cart where user_id = 30");
		
		pstmt.executeUpdate();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		PreparedStatement pstmt = ConnectionFactoryPostgres.getConnection().prepareStatement("delete from cart where user_id = 30");
		
		pstmt.executeUpdate();
		
	}

	@Test
	void createCartTest() throws SQLException {
		
		//creating a real stmt to be able to actually communicate with our db
		String sql = "insert into cart (user_id, total) values(?, ?)";
		
		Connection realConnection = ConnectionFactoryPostgres.getConnection();
		
		System.out.println(realConnection);
		
		PreparedStatement realStmt = realConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		//Spying on our real stmt, so that we can later verify the correct methods are invoked
		PreparedStatement spy = Mockito.spy(realStmt);
		
		System.out.println("Spy" + spy);
		
		System.out.println("Conn Mock" + connection);

		//setting up our Mock connection, to reaturn our real stmt, we are spying on
		//if we did not do this, and used a real connection on this test, the connection would create
		//a new statement inside of our createCart method, and we could not spy on it
		when(connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)).thenReturn(spy);
		
		daoPostgres.setConn(connection);
		
		//setting up the cart we want to create
		Cart cart = new Cart();
		
		cart.setTotal(0.0f);
		
		cart.setUserId(30);
		
		//call the create cart method that we are testing
		daoPostgres.createCart(cart);
		
		//verifying all the correct methods are being called on our REAL stmt
		//this can only work because we are spying on the stmt
		verify(spy).setInt(1, cart.getUserId());
		
		verify(spy).setFloat(2, cart.getTotal());
		
		verify(spy).executeUpdate();
		
		//making a second call to the db, to ensure that the cart was actually created
		PreparedStatement checkStmt = ConnectionFactoryPostgres.getConnection().prepareStatement("select * from cart where user_id = 30");
		
		ResultSet rs = checkStmt.executeQuery();
		
		assertTrue(rs.next());
		
		
	}

}
