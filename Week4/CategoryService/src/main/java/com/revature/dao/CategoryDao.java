package com.revature.dao;

import com.revature.pojo.Category;

public interface CategoryDao {
	
	public Category readCategoryByName(String categoryName);
	
	public Category addCategory(String categoryName);

}
