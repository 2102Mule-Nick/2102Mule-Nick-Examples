package com.revature;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class LambdaDriver {

	public static void main(String[] args) {
		
		Object o = new Object();
		
		System.out.println("Put in cost of items");
		
		Scanner scan = new Scanner(System.in);
		
		List<Double> costs = new LinkedList<>();
		
		double nextCost = 0.0;
		
		do {
			nextCost = scan.nextDouble();
			costs.add(nextCost);
		} while (nextCost != 0.0);
		
		Collections.sort(costs, (c1, c2) -> {
			if (c2 > c1) {
				return 1;
			} else if (c1 > c2) {
				return -1;
			} else {
				return 0;
			}
			
		});
		
		
		
		System.out.println(costs);
		
		scan.nextLine();
		
		System.out.println("enter state");
		
		String state = scan.nextLine();
		
		System.out.println("enter county");
		
		String county = scan.nextLine();
		
		double total = 0.0;
		
		if ("Conn".equals(state)) {
			if ("Fair".equals(county)) {
				total = getTotal(costs, (c) -> {
					double ret = c;
					ret *= 1.08;
					return ret;
				}, t -> true);
			} else {
				total = getTotal(costs, (c) -> {
					double ret = c;
					ret *= 1.06;
					return ret;
				}, t -> t > 1.0);
			}
		}
		
		System.out.println("Total: " + total);

	}

	public static double getTotal(List<Double> costs, TaxCalculation tax, Predicate<Double> p) {

		double total = 0;

		for (Double cost : costs) {
			total += cost;
		}
		
		if (p.test(total)) {
			return tax.calculateTax(total);
		}
		
		return total;

	}

}
