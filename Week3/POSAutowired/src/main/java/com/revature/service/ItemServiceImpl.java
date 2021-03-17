package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ItemDao;
import com.revature.pojo.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	private ItemDao itemDao;
	
	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItemByItemName(String itemName) {
		return itemDao.getByName(itemName);
	}

}
