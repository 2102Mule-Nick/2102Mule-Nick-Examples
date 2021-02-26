package com.revature.ui;

import java.util.Scanner;

public interface Menu {
	
	public Menu advance();
	
	public void displayOptions();
	
	public Menu previousMenu();
	
	public Scanner getScanner();
	
	public void setScanner(Scanner scan);

}
