package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

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

@ActiveProfiles("integration-test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {IntegrationConfig.class})
public class ItemRestockIntegrationTest {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ItemRestockRowMapper rowMapper;
	
	@Autowired
	ItemRestockDaoPostgres postgresDao;
	
	@Test
	public void getItemByProductId() {
		
		String sql = "select * from item where product_id = ?";
		
		int productId = 91;
		
		Item expected = new Item(productId, "Cap");
		
		Item returnItem = postgresDao.getItemByItemId(productId);
		
		verify(jdbcTemplate).queryForObject(sql, rowMapper, productId);
		
		assertEquals(expected, returnItem);
		
	}
	

}
