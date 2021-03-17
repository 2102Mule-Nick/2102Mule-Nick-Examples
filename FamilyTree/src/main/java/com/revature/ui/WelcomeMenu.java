package com.revature.ui;

import java.util.Scanner;

public class WelcomeMenu implements Menu {

	private Scanner scan;

	private Menu loginMenu;

	private Menu registrationMenu;

	private Menu nextMenu;
	
	private Menu updateMenu;
	
	private Menu deleteMenu;

	@Override
	public Menu advance() {
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		System.out.println("Welcome to Family Tree Manager.");
		System.out.println("What would you like to do?");
		System.out.println("1. Add Person to the Family tree");
		System.out.println("2. View the full family tree");
		System.out.println("3. update a Person's relationships in the tree");
		System.out.println("4. delete a Person from the tree");
		String answer = scan.nextLine();

		if ("1".equals(answer) || "Add Person to the Family tree".equals(answer)) {
			nextMenu = registrationMenu;
		} else if ("2".equals(answer)|| "View the full family tree".equals(answer)) {
			nextMenu = loginMenu;
		} else if ("3".equals(answer)|| "Update a Person's relationships in the tree".equals(answer)) {
			nextMenu = updateMenu;
		} else if ("4".equals(answer)|| "Delete a Person from the tree".equals(answer)) {
			nextMenu = deleteMenu;
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
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	public WelcomeMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WelcomeMenu(Menu loginMenu, Menu registractionMenu, Menu updateMenu, Menu deleteMenu) {
		super();
		this.loginMenu = loginMenu;
		this.registrationMenu = registractionMenu;
		this.updateMenu = updateMenu;
		this.deleteMenu = deleteMenu;
	}

}
