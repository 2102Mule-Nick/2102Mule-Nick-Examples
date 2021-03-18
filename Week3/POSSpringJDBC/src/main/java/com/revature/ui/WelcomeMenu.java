package com.revature.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMenu implements Menu {

	private Scanner scan;

	private Menu loginMenu;

	private Menu registractionMenu;

	private Menu nextMenu;
	
	private Menu updateMenu;

	@Override
	public Menu advance() {
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		System.out.println("Welcome to our application");
		System.out.println("Would you like to login, register, or update account info?");
		String answer = scan.nextLine();

		if ("login".equals(answer)) {
			nextMenu = loginMenu;
		} else if ("register".equals(answer)) {
			nextMenu = registractionMenu;
		} else if ("update".equals(answer)) {
			nextMenu = updateMenu;
		} else {
			System.out.println("invalid input");
			// redirect user to same welcome menu
			nextMenu = this;
		}
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		return this.scan;
	}

	@Override
	@Autowired //other non-Spring alternatives to @Autowired include @Resource and @Inject
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	public WelcomeMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Menu getLoginMenu() {
		return loginMenu;
	}

	@Autowired
	public void setLoginMenu(Menu loginMenu) {
		this.loginMenu = loginMenu;
	}

	public WelcomeMenu(Menu loginMenu, Menu registractionMenu, Menu updateMenu) {
		super();
		this.loginMenu = loginMenu;
		this.registractionMenu = registractionMenu;
		this.updateMenu = updateMenu;
	}

}
