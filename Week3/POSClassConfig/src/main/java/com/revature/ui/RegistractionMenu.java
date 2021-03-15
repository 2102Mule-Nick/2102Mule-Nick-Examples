package com.revature.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.exception.UserNameTaken;
import com.revature.pojo.User;
import com.revature.service.AuthService;

public class RegistractionMenu implements Menu {
	
	Logger log = Logger.getRootLogger();
	
	private Menu welcomeMenu;

	private Menu nextMenu;
	
	private Scanner scan;

	private AuthService authService;

	@Override
	public Menu advance() {
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		User user = new User();
		System.out.println("Please enter a new username:");
		user.setUsername(scan.nextLine());
		System.out.println("Please enter a new password:");
		user.setPassword(scan.nextLine());
		if (!authService.existingUser(user)) {
			log.info("Username: " + user.getUsername() + " is available.");
			try {
				authService.registerUser(user);
				nextMenu = null;
			} catch (UserNameTaken e) {
				System.out.println("Username taken, please try again");
				nextMenu = welcomeMenu;
			}
		} else {
			log.warn("Username: " + user.getUsername() + " is already taken.");
			System.out.println("Username taken, please try again");
			nextMenu = welcomeMenu;
		}
	}

	@Override
	public Menu previousMenu() {
		return null;
	}

	@Override
	public Scanner getScanner() {
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	public RegistractionMenu() {
		super();
	}

	public RegistractionMenu(AuthService authService, Menu welcomeMenu) {
		super();
		this.authService = authService;
		this.welcomeMenu = welcomeMenu;
	}

	public Menu getWelcomeMenu() {
		return welcomeMenu;
	}

	public void setWelcomeMenu(Menu welcomeMenu) {
		this.welcomeMenu = welcomeMenu;
	}

	public Menu getNextMenu() {
		return nextMenu;
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

}
