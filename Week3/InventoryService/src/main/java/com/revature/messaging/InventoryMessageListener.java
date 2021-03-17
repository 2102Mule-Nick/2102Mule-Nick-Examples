package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.revature.config.AppConfig;
import com.revature.dao.InventoryDao;
import com.revature.dto.ItemInventory;
import com.revature.pojo.Item;

@Service
public class InventoryMessageListener{

	InventoryDao inventoryDao;
	
	@Autowired
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	@JmsListener(destination = AppConfig.EXAMPLE_QUEUE)
	public void onExampleMessage(Message message) {
		
		if (message instanceof TextMessage) {
			
			try {
				String text = ((TextMessage)message).getText();
				System.out.println("Hanlding message from InventoryService: " + text);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	@JmsListener(destination = AppConfig.INVENTORY_QUEUE)
	public void onInventoryMessage(Message message) {
		
		System.out.println("Handling Inventory Message...");
		
		if (message instanceof ObjectMessage) {
			
			ObjectMessage om = (ObjectMessage)message;
			try {
				ItemInventory ii = (ItemInventory)om.getObject();
				System.out.println("Item: " + ii.getItem());
				System.out.println("Quantity: " + ii.getQuantity());
				inventoryDao.updateQuantity(ii.getItem(), ii.getQuantity());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
