package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.ui.Menu;
import com.revature.ui.WelcomeMenu;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Menu menu = appContext.getBean("welcomeMenu", WelcomeMenu.class);
		
		do {
			menu.displayOptions();
			menu = menu.advance();
		} while (menu != null);
		
	}

}
