package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoPostgres;
import com.revature.pojo.User;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;
import com.revature.ui.LoginMenu;
import com.revature.ui.Menu;
import com.revature.ui.RegistractionMenu;
import com.revature.ui.UpdateMenu;
import com.revature.ui.WelcomeMenu;

public class RefactoredDriver {
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		UserDao userDao = new UserDaoPostgres();
		
		/*  This second team test
		 *
		User testUser = new User("iyad", "hahahahahaha");
		userDao.removeUser(testUser);
		
		scan.nextLine();
		*/
		
		AuthService authService = new AuthServiceImpl(userDao);
		
		Menu register = new RegistractionMenu();
		
		Menu login = new LoginMenu(authService);
		
		Menu updateMenu = new UpdateMenu(authService);
		
		Menu welcomeMenu = new WelcomeMenu(login, register, updateMenu);
		
		((RegistractionMenu)register).setWelcomeMenu(welcomeMenu);
		
		((RegistractionMenu)register).setAuthService(authService);
		
		login.setScanner(scan);
		
		register.setScanner(scan);
		
		welcomeMenu.setScanner(scan);
		
		updateMenu.setScanner(scan);
		
		Menu nextMenu = welcomeMenu;
		
		do {
			nextMenu.displayOptions();
			
			nextMenu = nextMenu.advance();
			
		} while (nextMenu != null);
		
		
		
	}

}
