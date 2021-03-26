package com.revature.test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.revature.dao.ItemRestockDaoPostgres;
import com.revature.dao.ItemRestockRowMapper;
import com.revature.pojo.Item;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
class ItemRestockUnitTest {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ItemRestockRowMapper itemRestockRowMapper;
	
	@Autowired
	ItemRestockDaoPostgres postgresDao;
	
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
	void getItemByProductId() {
		
		int productId = 7;
		
		String sql = "select * from item where product_id = ?";
		
		List<Item> itemList = new ArrayList<>();
		
		Item item = new Item(productId, "bed");
		
		
		when(jdbcTemplate.queryForObject(sql, itemRestockRowMapper, productId)).thenReturn(item);
		
		Item itemReturn = postgresDao.getItemByItemId(productId);
		
		verify(jdbcTemplate).queryForObject(sql, itemRestockRowMapper, productId);
		
		assertEquals(item, itemReturn);
	
	}

}
