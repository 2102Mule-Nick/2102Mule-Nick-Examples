package com.revature.ui;

import java.util.Scanner;

import com.revature.pojo.User;
import com.revature.service.AuthService;

public class DeleteMenu implements Menu {
	
	Scanner scan;

	private AuthService authService;

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub

		System.out.println("Enter your father name");
		String answer = scan.nextLine();
		System.out.println("Enter your mother name:");
		String password = scan.nextLine();
		System.out.println("Enter your new first name:");
		String firstname = scan.nextLine();
		System.out.println("Enter your new last name:");
		String lastname = scan.nextLine();

		User user = new User(answer, password, firstname, lastname);

		authService.deleteUser(user);
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub
		this.scan = scan;
	}

	public DeleteMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteMenu(AuthService authService) {
		super();
		this.authService = authService;
	}

}
