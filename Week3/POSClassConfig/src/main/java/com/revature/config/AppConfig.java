package com.revature.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.dao.UserDaoPostgres;
import com.revature.service.AuthServiceImpl;
import com.revature.ui.LoginMenu;
import com.revature.ui.WelcomeMenu;

@Configuration
public class AppConfig {

	@Bean
	public WelcomeMenu welcomeMenu(LoginMenu loginMenu, Scanner consoleInScanner) {
		WelcomeMenu welcomeMenu = new WelcomeMenu();
		welcomeMenu.setLoginMenu(loginMenu);
		welcomeMenu.setScanner(consoleInScanner);
		return welcomeMenu;
	}
	
	@Bean
	public LoginMenu loginMenu(AuthServiceImpl authService, Scanner consoleInScanner) {
		LoginMenu loginMenu = new LoginMenu();
		loginMenu.setAuthService(authService);
		loginMenu.setScanner(consoleInScanner);
		return loginMenu;
	}
	
	@Bean
	@Scope("singleton")
	public Scanner consoleInScanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	@Scope("singleton")//default scope
	public AuthServiceImpl authService(UserDaoPostgres userDao) {
		//UserDao userDao = new UserDaoPostgres(); does not use userDao in spring bean container
		AuthServiceImpl authService =  new AuthServiceImpl();
		authService.setUserDao(userDao);
		return authService;
	}
	
	@Bean
	public UserDaoPostgres userDao() {
		return new UserDaoPostgres();
	}
	
}
