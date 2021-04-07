package com.revature.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcInsert simpleJdbcInsert;
	
	private DataSource dataSource;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	public void setSimpleJdbcInsert(SimpleJdbcInsert simpleJdbcInsert) {
		this.simpleJdbcInsert = simpleJdbcInsert;
	}



	@Override
	public Category readCategoryByName(String categoryName) {

		String sql = "select * from category where category_name = ?";

		List<Category> categoryList = jdbcTemplate.query(sql,
				(rs, id) -> new Category(rs.getInt("category_id"), 
						rs.getString("category_name")), categoryName);
		
		if (categoryList.size() > 0) {
			return categoryList.get(0);
		}
		
		return null;

	}

	@Override
	public Category addCategory(String categoryName) {

		if (simpleJdbcInsert == null) {
			simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
					.withTableName("category")
					.usingGeneratedKeyColumns("category_id");

		}
		
		Map<String, Object> fields = new HashMap<>();
		
		fields.put("category_name", categoryName);
		
		return new Category((int)simpleJdbcInsert.executeAndReturnKey(fields), categoryName);
		
	}

}
