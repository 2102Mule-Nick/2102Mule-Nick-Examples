package com.revature.messaging;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.revature.dto.ItemInventory;
import com.revature.pojo.Item;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	
	private Queue exampleQueue;

	private Topic topic;
	
	private Queue inventoryQueue;
	
	
	
	@Autowired
	@Qualifier("destinationQueue")
	public void setExampleQueue(Queue exampleQueue) {
		this.exampleQueue = exampleQueue;
	}

	@Autowired
	public void setInventoryQueue(Queue inventoryQueue) {
		this.inventoryQueue = inventoryQueue;
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
	@Autowired
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public void simpleSend(String msg) {
		
//		jmsTemplate.send(queue, (s) -> s.createTextMessage(msg));

		jmsTemplate.send(topic, (s) -> s.createTextMessage(msg));
		
	}
	
	public void sendToQueue(String msg) {
		jmsTemplate.send(exampleQueue, (s) -> s.createTextMessage(msg));
	}
	
	public void sendToInventoryQueue(Item item, int quantity) {
		
		ItemInventory ii = new ItemInventory(item, quantity);
		
		jmsTemplate.send(inventoryQueue, (s) -> s.createObjectMessage(ii));
	}
	
}
