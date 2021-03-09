package com.revature.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.util.ConnectionFactoryPostgres;

/*
 * Interfaces of JDBC:
 * 1. Driver Manager
 * 2. Connection
 * 3. Statement
 * 4. SQLException
 * 5. Result Set
 * 6. Prepared Statement
 * 7. Callable Statement
 */

class CartFuncProcTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetTotalSQLFunc() throws SQLException {

		Connection conn = ConnectionFactoryPostgres.getConnection();

		int cartId = 15;

		String sql = "select getTotal(?)";

		// JDBC callable statement is used to call functions and stored procs
		CallableStatement call = conn.prepareCall(sql);

		call.setInt(1, cartId);

		ResultSet rs = call.executeQuery();

		rs.next();

		System.out.println(rs.getInt(1));

	}

	@Test
	void testUpdateTotalSQLProc() throws SQLException {

		Connection conn = ConnectionFactoryPostgres.getConnection();

		int cartId = 20;

		String sql = "call updateTotal(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		
		call.setInt(1, cartId);
		
		call.executeUpdate();

	}
	
	@Test
	void testTransaction() {
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionFactoryPostgres.getConnection();
			
			conn.setAutoCommit(false);
			
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			
			//... run all jdbc code
			
			Savepoint mySavePoint = conn.setSavepoint("mySavePoint");
			
			//...
			
			if (false) {
				conn.rollback(mySavePoint);
			}
			
			conn.commit();
			
			
		} catch (SQLException e) {
			try {
			conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
			conn.setAutoCommit(true);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
	}

}
