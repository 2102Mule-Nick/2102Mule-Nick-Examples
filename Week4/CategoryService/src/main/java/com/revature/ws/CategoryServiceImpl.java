package com.revature.ws;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CategoryDao;
import com.revature.exception.CategoryDoesNotExist;
import com.revature.pojo.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
	
	private Logger log;
	
	@Autowired
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Autowired
	public void setLog(Logger log) {
		this.log = log;
	}



	@Override
	public Category findCategoryByName(String categoryName) throws CategoryDoesNotExist {

		log.info("Hanlding find category request for " + categoryName);
		
		Category category = categoryDao.readCategoryByName(categoryName);
		
		if (category == null) {
			throw new CategoryDoesNotExist();
		}
		
		return category;
	}

	@Override
	public Category createCategory(String categoryName) {
		
		log.info("Hanlding create category request for " + categoryName);
		
		return categoryDao.addCategory(categoryName);
	}

}
