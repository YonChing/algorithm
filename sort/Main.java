package org.rudolf.sort;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("\t\t\t\t\tCompare Sort\n");
		System.out.print("\t\t\t\t\t1 select\n");
		System.out.print("\t\t\t\t\t2 bubble\n");
		System.out.print("\t\t\t\t\t3 insert\n");
		System.out.print("\t\t\t\t\t4 heap\n");
		System.out.print("\t\t\t\t\t5 merge\n");
		System.out.print("\t\t\t\t\t6 quick\n");
		System.out.print("\t\t\t\t\t7 shell\n");
		System.out.print("Please select the number of sort algorithm type: ");
		Scanner sc = new Scanner(System.in);
		int selector = sc.nextInt();
		
		if (selector > 7 && selector < 1) {
			System.out.print("Error!Not a correct number\n");
		} else {		
			Context context = null;
			
			context = new Context(Factory.create(selector));
			context.execute();		
		}		

	}

}
