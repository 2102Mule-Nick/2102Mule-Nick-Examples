package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

@Service
public class InventoryMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
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

}
