package com.revature.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.revature.exception.CategoryDoesNotExist;
import com.revature.pojo.Category;

@WebService
public interface CategoryService {
	
	@WebMethod
	public Category findCategoryByName(String categoryName) throws CategoryDoesNotExist;
	
	@WebMethod
	public Category createCategory(String categoryName);

}
