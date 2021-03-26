package com.revature.test;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.dao.ItemRestockDaoPostgres;
import com.revature.dao.ItemRestockExtractor;
import com.revature.dao.ItemRestockRowMapper;

@Profile("test")
@Configuration
public class TestConfig {

	@Bean
	public JdbcTemplate mockJdbcTemplate() {
		System.out.println("running right config file");
		return Mockito.mock(JdbcTemplate.class);
	}

	@Bean
	public ItemRestockRowMapper mockItemRestockRowMapper() {
		return Mockito.mock(ItemRestockRowMapper.class);
	}

	@Bean
	public ItemRestockExtractor extractor() {
		return Mockito.mock(ItemRestockExtractor.class);
	}

	@Bean
	public ItemRestockDaoPostgres itemRestockDao(JdbcTemplate mockJdbcTemplate,
			ItemRestockRowMapper mockItemRestockRowMapper) {
		ItemRestockDaoPostgres itemRestockDao = new ItemRestockDaoPostgres();

		itemRestockDao.setJdbcTemplate(mockJdbcTemplate);

		itemRestockDao.setItemRestockRowMapper(mockItemRestockRowMapper);

		return itemRestockDao;

	}

}
