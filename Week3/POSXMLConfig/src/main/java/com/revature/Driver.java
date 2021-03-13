package com.revature;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.ui.LoginMenu;
import com.revature.ui.Menu;

public class Driver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("autowired.xml");
		
		Menu menu = (Menu) appContext.getBean("welcomeMenu");
		
		Menu loginMenu = (Menu) appContext.getBean("loginMenu");
		
		loginMenu.setScanner(scan);
		
		menu.setScanner(scan);
		
		do {
			menu.displayOptions();
			menu = menu.advance();
		} while(menu != null);
		
	}

}
