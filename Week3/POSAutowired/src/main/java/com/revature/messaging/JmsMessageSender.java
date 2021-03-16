package com.revature.messaging;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	
	private Queue queue;

	private Topic topic;
	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Autowired
	public void setQueue(Queue queue) {
		this.queue = queue;
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
		jmsTemplate.send(queue, (s) -> s.createTextMessage(msg));
	}
	
}
