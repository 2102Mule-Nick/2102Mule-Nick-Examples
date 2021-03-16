package com.revature;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.ui.Menu;
import com.revature.ui.WelcomeMenu;

public class Driver {

	public static void main(String[] args) {
		
		//Only necessary if you are not running a standalone ActiveMQ broker
		//setUpActiveMQ();

		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Menu menu = appContext.getBean("welcomeMenu", WelcomeMenu.class);
		
		do {
			menu.displayOptions();
			menu = menu.advance();
		} while (menu != null);
		
	}
	
	private static void setUpActiveMQ() {
		
		BrokerService broker;
		
		try {
			broker = BrokerFactory.createBroker("broker:(" + AppConfig.BROKER_URL + ")");
			broker.getAdminView();
			broker.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
