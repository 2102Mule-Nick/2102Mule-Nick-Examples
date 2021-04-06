package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.service.FlashCardServiceFinder;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println(appContext.getBean(FlashCardServiceFinder.class).retrieveAllFlashCards());
		
	}
	
}
