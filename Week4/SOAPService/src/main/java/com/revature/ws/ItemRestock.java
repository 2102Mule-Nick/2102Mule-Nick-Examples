package com.revature.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.revature.pojo.Item;

@WebService
public interface ItemRestock {
	
	@WebMethod
	public String restockItem(Item item, int quantity);
	
	@WebMethod
	public Boolean canRestock(Item item);
	
	@WebMethod
	public String discontinueItem(Item item);

}
