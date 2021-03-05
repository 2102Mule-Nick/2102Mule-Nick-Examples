package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoPostgres;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;
import com.revature.ui.LoginMenu;
import com.revature.ui.Menu;
import com.revature.ui.RegistractionMenu;
import com.revature.ui.WelcomeMenu;

public class RefactoredDriver {
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		UserDao userDao = new UserDaoPostgres();
		
		AuthService authService = new AuthServiceImpl(userDao);
		
		Menu register = new RegistractionMenu();
		
		Menu login = new LoginMenu(authService);
		
		Menu welcomeMenu = new WelcomeMenu(login, register);
		
		((RegistractionMenu)register).setWelcomeMenu(welcomeMenu);
		
		((RegistractionMenu)register).setAuthService(authService);
		
		login.setScanner(scan);
		
		register.setScanner(scan);
		
		welcomeMenu.setScanner(scan);
		
		Menu nextMenu = welcomeMenu;
		
		do {
			nextMenu.displayOptions();
			
			nextMenu = nextMenu.advance();
			
		} while (nextMenu != null);
		

		
	}

}
