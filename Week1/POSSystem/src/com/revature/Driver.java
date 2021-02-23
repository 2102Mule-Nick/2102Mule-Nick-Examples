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

	public static void main(String[] args) {
		
		//set up a list of items
		ItemInventory itemInventory = new ItemInventory();
		itemInventory.addItem(new Item(1, 10.0f, "gluteen free pancakes", 12000000, 0.0f));
		itemInventory.addItem(new Item(2, 0.25f, "eggs", 30, 0.0f));
		itemInventory.addItem(new Item(3, 40.0f, "cookies", 100, 20.0f));

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

		String username; // = "usr"; // = scanner.

		// char[] username2 = new char[] {'u','s','r'};

		// username += "name";

		// username2 += "name";

		System.out.println("Please enter username: ");

		username = scanner.nextLine();

		System.out.println("Please enter password: ");

		String password = scanner.nextLine();

		// System.out.println("Welcome user " + username + " with password: " +
		// password);

		String authPassword = userList.get(username);

		if (authPassword != null) {

			if (authPassword.equals(password) == true) {
				System.out.println("Welcome to the system " + username);
				System.out.println(itemInventory.toString());
			} else {
				System.out.println("user is not authenticated");
			}
		} else {
			System.out.println("user not found");
		}
		
		

	}

}
