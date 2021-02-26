package com.revature.ui;

import java.util.Scanner;

import com.revature.service.AuthService;

public class LoginMenu implements Menu{
	
	private AuthService authService;
	
	private Scanner scan;
	
	public Scanner getScanner() {
		return scan;
	}

	public void setScanner(Scanner scan) {
		this.scan = scan;
	}
	
	public AuthService getUserService() {
		return authService;
	}

	public void setUserService(AuthService userService) {
		this.authService = userService;
	}

	@Override
	public Menu advance() {
		return null;
	}

	@Override
	public void displayOptions() {
		System.out.println("Please Enter Username");
		String username = scan.nextLine();
		System.out.println("Please Enter Password");
		String password = scan.nextLine();
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

}
