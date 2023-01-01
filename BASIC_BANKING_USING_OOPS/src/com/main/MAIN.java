package com.main;

import java.util.Scanner;

import com.Banks.Affiliated.*;

public class MAIN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ch;
		OPERATION1 obj = new OPERATION1();
		do {
			try {

				obj.opr(); // OPERATIONS... METHOD CALLING

			} catch (Exception e) {

				System.out.println(
						"YOUR INPUT IS MISMATCHED WITH THE SERVICES ...PLS CONSIDER AS FOLLOWS\nENTER VALID INFO...");

			}
			System.out.println("PLS TYPE YES...TO REDIRECT MAIN SYSTEM");
			ch = sc.next();
		} while (ch.equalsIgnoreCase("yes"));

		System.out.println("\n\n=================================================================================");
		System.out.println("\n\nTHANK YOU FOR USING OUR CUSTOMISED BANKING SYSTEM ...HEAD OF BANK INDIA");
		System.out.println("\n\n=================================================================================");

	}

}