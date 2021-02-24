package com.revature; //best practice is to use reverse domain name

import java.util.Hashtable;
import java.util.List;
//import java.awt.List;
import java.util.Scanner;

import com.revature.dao.ItemInventory;
import com.revature.pojo.Item;

//imports go here

/*
 * Point of Sales System Requirments
 * 	- have some user interface (menus)
 * 		- login +
 * 		- cart
 * 		- view items
 *	- be able to store items for sale
 *	- handle purchase transactions
 *	- store orders
 *	- calculate total for purchases
 */

public class Driver {
	
	private static String username;
	
	private static String password;
	
	/*
	 * static - belongs to the class
	 * exists in only one place in memory
	 * all instances share
	 */
	public static void main(String[] args) {
		
		final Item constantItem = new Item(4, 0.0f, "stuff", 0, 0.0f);
		
		constantItem.setItemName("new name"); // can do anything else with this object's values inside even though it is final
		
		//constantItem = new Item(); cannot rereferrence
		
		//set up a list of items
		/*
		 * ItemInventory ii = new ItemInventory(); ii.addItem(new Item());
		 */
		ItemInventory.addItem(new Item(1, 10.0f, "gluteen free pancakes", 12000000, 0.0f));
		ItemInventory.addItem(new Item(2, 0.25f, "eggs", 30, 0.0f));
		ItemInventory.addItem(new Item(3, 40.0f, "cookies", 100, 20.0f));

		// set up user list for authentication
		Hashtable<String, String> userList = new Hashtable<>();

		userList.put("keyur", "iamhappy");
		userList.put("justbrian", "hunter12");
		userList.put("gael", "g22");

		List<String> list;
		java.awt.List list2; // accessing using fully qualified classname

		// First collect username and password
		Scanner scanner = new Scanner(System.in);

		// primatives: int; double; long; float; char; boolean; byte; short

		//String username; // = "usr"; // = scanner.

		// char[] username2 = new char[] {'u','s','r'};

		// username += "name";

		// username2 += "name";

		System.out.println("Please enter username: ");

		Driver.username = scanner.nextLine();

		System.out.println("Please enter password: ");

		Driver.password = scanner.nextLine();

		// System.out.println("Welcome user " + username + " with password: " +
		// password);

		String authPassword = userList.get(username);

		if (authPassword != null) {

			if (authPassword.equals(password) == true) {
				System.out.println("Welcome to the system " + username);
				System.out.println(ItemInventory.print());
				//itemInventory.super.toString(); not possible
			} else {
				System.out.println("user is not authenticated");
			}
		} else {
			System.out.println("user not found");
		}
		
		

	}

}
