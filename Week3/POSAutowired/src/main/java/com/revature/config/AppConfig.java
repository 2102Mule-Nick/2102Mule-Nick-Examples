package com.revature.config;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.revature")
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	@Scope("singleton")
	public Scanner consoleInScanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public Logger log() {
		return Logger.getRootLogger();
	}
	
}
