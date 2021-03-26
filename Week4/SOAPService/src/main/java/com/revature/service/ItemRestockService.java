package com.revature.service;

import javax.jws.WebMethod;

import com.revature.pojo.Item;

public interface ItemRestockService {
	
	public String restockItem(Item item, int quantity);
	
	public Boolean canRestock(Item item);
	
	public String discontinueItem(Item item);

}
