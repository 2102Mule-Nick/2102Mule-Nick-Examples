package com.revature.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	
	private Queue queue;

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Autowired
	public void setQueue(Queue queue) {
		this.queue = queue;
	}
	
	public void simpleSend(String msg) {
		
		jmsTemplate.send(queue, (s) -> s.createTextMessage(msg));
		
	}
	
}
