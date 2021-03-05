package com.revature.ui;

import java.util.Scanner;

import com.revature.service.AuthService;

public class UpdateMenu implements Menu {

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

		System.out.println("Enter your username");
		String answer = scan.nextLine();
		System.out.println("Enter your new password:");
		String new_password = scan.nextLine();
		
		
		authService.existingUser(user, new_password);
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

}