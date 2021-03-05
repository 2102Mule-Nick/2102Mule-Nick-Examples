package com.revature;

public class AccessingClass {
	
	public void someMethod() {
		//I can access it this way because of 2 properties
		//because it is public, I can access it at all (I can see it)
		//I can access it using the classname [opposed to an object instance] because it
		//is static
		int localInt = ExampleDriver.counter;
		//int localInt2 = ExampleDriver.nonStaticCounter;
		ExampleDriver exampleDriver = new ExampleDriver();
		int localInt2 = exampleDriver.nonStaticCounter;
	}

}
