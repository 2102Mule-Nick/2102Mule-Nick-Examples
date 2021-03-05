package com.revature;

public class ExampleDriver {
	
	private static int counter = 7; //static scope
	
	static {
		counter ++;
	}
	
	private int nonStaticCounter; //instance scope
	
	public static void main(String[] args) {
		
		counter++;
		counter++;
		counter++;
		counter++;
		/*
		 * ExampleDriver exampleDriver1 = new ExampleDriver(); ExampleDriver
		 * exampleDriver2 = new ExampleDriver(); ExampleDriver exampleDriver3 = new
		 * ExampleDriver(); ExampleDriver exampleDriver4 = new ExampleDriver();
		 * ExampleDriver exampleDriver5 = new ExampleDriver();
		 * 
		 * exampleDriver1.nonStaticCounter++; exampleDriver1.nonStaticCounter++;
		 * exampleDriver1.nonStaticCounter++;
		 */
		
		
		System.out.println("Static counter " + counter);
		/*
		 * System.out.println("counter 1 " + exampleDriver1.nonStaticCounter);
		 * System.out.println("counter 2 " + exampleDriver2.nonStaticCounter);
		 * System.out.println("counter 3 " + exampleDriver3.nonStaticCounter);
		 * System.out.println("counter 4 " + exampleDriver4.nonStaticCounter);
		 * System.out.println("counter 5 " + exampleDriver5.nonStaticCounter);
		 */
		
		
	}
	
	public ExampleDriver() {
		counter++;
		nonStaticCounter++;
	}

}
