package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
		if (message instanceof TextMessage) {
			
			try {
				String msg = ((TextMessage) message).getText();
				System.out.println("================MESSAGE RECIEVED: " + msg + "===================");
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
