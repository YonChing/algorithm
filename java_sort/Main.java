package org.rudolf.sort;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean flag = false;
		
		while (!flag) {
			System.out.print("Please input the length of the sort array:");
			Scanner sc = new Scanner(System.in);
			String sr = sc.next();
			Pattern p = Pattern.compile("^[0-9]+");
			Matcher m = p.matcher(sr);
			if (m.matches()) {
				Utility.setLen(Integer.parseInt(sr));
				flag = true;
			} else {
				System.out.print("Error!Not a correct number\n");				
			}
		}
		
		while (flag) {
			System.out.print("\t\t\t\t\tCompare Sort\n");
			System.out.print("\t\t\t\t\t1 select\n");
			System.out.print("\t\t\t\t\t2 bubble\n");
			System.out.print("\t\t\t\t\t3 insert\n");
			System.out.print("\t\t\t\t\t4 heap\n");
			System.out.print("\t\t\t\t\t5 merge\n");
			System.out.print("\t\t\t\t\t6 quick\n");
			System.out.print("\t\t\t\t\t7 shell\n");
			System.out.print("\t\t\t\t\t8 exit\n");
			System.out.print("Please select the number of sort algorithm type: ");
			Scanner sc = new Scanner(System.in);
			String sr = sc.next();
			
			Pattern p = Pattern.compile("^[0-9]");
			Matcher m = p.matcher(sr);
			
			if (m.matches()) {
				int selector = Integer.parseInt(sr);
				
				if (selector < 8 && selector > 0) {
					Context context = new Context(Factory.create(selector));
					context.execute();		
				} else if (selector == 8) {
					flag = false;
				} else {					
					System.out.print("Error!Not a correct number\n");
				}
			} else {
				System.out.print("Error!Not a correct number\n");
			}	
		}
	}
}
