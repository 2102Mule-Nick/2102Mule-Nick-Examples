package com.revature;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("Listening for messages....");
		
		String exit = "";
		
		Scanner scan = new Scanner(System.in);
		
		do {
			
			exit = scan.nextLine();
			
		} while (!"exit".equals(exit));
		
	}

}
