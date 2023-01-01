package com.main;

import java.util.Scanner;

import com.Banks.Affiliated.HDFC;
import com.Banks.Affiliated.axiesbank;
import com.Banks.Affiliated.icicibanking;
import com.Banks.Affiliated.sbibank;
import com.Banks.Affiliated.unionbanking;

public class OPERATION1 {
	public void opr() {
		Scanner sc = new Scanner(System.in);
		String choice;
		System.out.println("\n================>  WELCOME TO BANKING <=============\n\n");

		do {

			System.out.println("=====> CHOOSE UR OPTION FROM BELOW BANKING APPLICATIONS ....!!<======\n");
			System.out.println("1  FOR SBI LIFE  ");
			System.out.println("2  FOR AXIES BANK");
			System.out.println("3  FOR ICICI BANK ");
			System.out.println("4  FOR UNION BANK ");
			System.out.println("5  FOR HDFC BANK ");

			System.out.println("\n\n=================================================================================");
			int ch = sc.nextInt();

			System.out.print("ENTER UR NAME : ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("ENTER UR ACCOUNT NUMBER : ");
			int acc = sc.nextInt();
			System.out.println("ENTER UR ADDRESS : ");
			sc.nextLine();
			String add = sc.nextLine();

			sbibank o = new sbibank(); // SBI OBJ CREATION THESE OBJ WILL USED IN ALL REQUIRED SAME OPERATIONS
			operation so = new operation();

			switch (ch) {
			case 1: {

				System.out.println(
						"\n=======> WELCOME TO SBI PERSONAL ACCOUNT >>> Mr." + name.toUpperCase() + " <=========\n\n");
				String ch1;

				do {
					so.op(); // METHOD CALLING HERE ... RELATED TO SERVICES PROVIDED

					int c = sc.nextInt();

					switch (c) {
					case 1: {
						o.user_info(name, acc, add);
						break;
					}
					case 2: {
						System.out.println("ENTER AMOUNT TO ADD ...");
						int am = sc.nextInt();
						o.add_money(am);
						break;
					}
					case 3: {
						System.out.println("ENTER HOW MUCH MONEY TO WITHDRAW  ");
						int s = sc.nextInt();
						o.withdrals(s);
						break;
					}
					case 4: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						o.loan_intrest(m, y);
						break;
					}
					case 5: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						o.crop_loan(m, y);
						break;
					}
					case 6: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						o.gold_loan(m, y);

						break;
					}
					case 7: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						o.gold_loan(m, y);
						break;
					}

					default:
						System.out.println("CHEERS OF THE DAY .... U HAVE CHOOSEN SOMETHING DIFFERENT  !!");
					}

					System.out.println("\nDO YOU WANT TO CONTINUEEE IN SBI BANK PLS TYPE YES ......!!!");
					ch1 = sc.next();

				} while (ch1.equalsIgnoreCase("yes"));

				break;

			}
			case 2: {

				axiesbank ob = new axiesbank();
				System.out.println("\n=======> WELCOME TO AXIES BANK'S PERSONAL ACCOUNT >>> Mr." + name.toUpperCase()
						+ " <=========\n\n");
				String ch1;

				do {
					so.op(); // METHOD CALLING HERE ... RELATED TO SERVICES PROVIDED

					int c = sc.nextInt();

					switch (c) {
					case 1: {

						o.user_info(name, acc, add);
						break;
					}
					case 2: {
						System.out.println("ENTER AMOUNT TO ADD ...");
						int am = sc.nextInt();
						o.add_money(am);
						break;
					}
					case 3: {
						System.out.println("ENTER HOW MUCH MONEY TO WITHDRAW  ");
						int s = sc.nextInt();
						o.withdrals(s);
						break;
					}
					case 4: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						ob.loan_intrest(m, y);
						break;
					}
					case 5: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						ob.crop_loan(m, y);
						break;
					}
					case 6: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						ob.gold_loan(m, y);

						break;
					}
					case 7: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						ob.gold_loan(m, y);
						break;
					}

					default:
						System.out.println("CHEERS OF THE DAY .... U HAVE CHOOSEN SOMETHING DIFFERENT  !!");
					}

					System.out.println("\nDO YOU WANT TO CONTINUEEE IN AXIES BANK PLS TYPE YES ......!!!");
					ch1 = sc.next();

				} while (ch1.equalsIgnoreCase("yes"));

				break;
			}
			case 3: {
				icicibanking obj = new icicibanking();
				System.out.println("\n=======> WELCOME TO ICICI PERSONAL ACCOUNT >>> Mr." + name.toUpperCase()
						+ " <=========\n\n");
				String ch1;

				do {
					so.op(); // METHOD CALLING HERE ... RELATED TO SERVICES PROVIDED

					int c = sc.nextInt();

					switch (c) {
					case 1: {
						o.user_info(name, acc, add);
						break;
					}
					case 2: {
						System.out.println("ENTER AMOUNT TO ADD ...");
						int am = sc.nextInt();
						o.add_money(am);
						break;
					}
					case 3: {
						System.out.println("ENTER HOW MUCH MONEY TO WITHDRAW  ");
						int s = sc.nextInt();
						o.withdrals(s);
						break;
					}
					case 4: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj.loan_intrest(m, y);
						break;
					}
					case 5: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj.crop_loan(m, y);
						break;
					}
					case 6: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj.gold_loan(m, y);

						break;
					}
					case 7: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj.gold_loan(m, y);
						break;
					}

					default:
						System.out.println("CHEERS OF THE DAY .... U HAVE CHOOSEN SOMETHING DIFFERENT  !!");
					}

					System.out.println("\nDO YOU WANT TO CONTINUEEE IN ICICI BANK PLS TYPE YES ......!!!");
					ch1 = sc.next();

				} while (ch1.equalsIgnoreCase("yes"));

				break;

			}
			case 4: {

				unionbanking obj2 = new unionbanking();
				System.out.println("\n=======> WELCOME TO UNION PERSONAL ACCOUNT >>> Mr." + name.toUpperCase()
						+ " <=========\n\n");
				String ch1;

				do {
					so.op(); // METHOD CALLING HERE ... RELATED TO SERVICES PROVIDED

					int c = sc.nextInt();

					switch (c) {
					case 1: {
						o.user_info(name, acc, add);
						break;
					}
					case 2: {
						System.out.println("ENTER AMOUNT TO ADD ...");
						int am = sc.nextInt();
						o.add_money(am);
						break;
					}
					case 3: {
						System.out.println("ENTER HOW MUCH MONEY TO WITHDRAW  ");
						int s = sc.nextInt();
						o.withdrals(s);
						break;
					}
					case 4: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj2.loan_intrest(m, y);
						break;
					}
					case 5: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj2.crop_loan(m, y);
						break;
					}
					case 6: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj2.gold_loan(m, y);

						break;
					}
					case 7: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj2.gold_loan(m, y);
						break;
					}

					default:
						System.out.println("CHEERS OF THE DAY .... U HAVE CHOOSEN SOMETHING DIFFERENT  !!");
					}

					System.out.println("\nDO YOU WANT TO CONTINUEEE IN UNION BANK PLS TYPE YES ......!!!");
					ch1 = sc.next();

				} while (ch1.equalsIgnoreCase("yes"));

				break;

			}
			case 5: {
				HDFC obj3 = new HDFC();
				System.out.println(
						"\n=======> WELCOME TO HDFC PERSONAL ACCOUNT >>> Mr." + name.toUpperCase() + " <=========\n\n");
				String ch1;

				do {
					so.op(); // METHOD CALLING HERE ... RELATED TO SERVICES PROVIDED

					int c = sc.nextInt();

					switch (c) {
					case 1: {
						o.user_info(name, acc, add);
						break;
					}
					case 2: {
						System.out.println("ENTER AMOUNT TO ADD ...");
						int am = sc.nextInt();
						o.add_money(am);
						break;
					}
					case 3: {
						System.out.println("ENTER HOW MUCH MONEY TO WITHDRAW  ");
						int s = sc.nextInt();
						o.withdrals(s);
						break;
					}
					case 4: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj3.loan_intrest(m, y);
						break;
					}
					case 5: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj3.crop_loan(m, y);
						break;
					}
					case 6: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj3.gold_loan(m, y);

						break;
					}
					case 7: {
						System.out.println("ENTER MONEY YOU WANT TO GET LOAN ");
						int m = sc.nextInt();
						System.out.println("PAYMENT REPAY IN YEARS ");
						int y = sc.nextInt();
						obj3.gold_loan(m, y);
						break;
					}

					default:
						System.out.println("CHEERS OF THE DAY .... U HAVE CHOOSEN SOMETHING DIFFERENT  !!");
					}

					System.out.println("\nDO YOU WANT TO CONTINUEEE IN HDFC BANK PLS TYPE YES ......!!!");
					ch1 = sc.next();
					System.out.println(
							"\n\n=================================================================================");

				} while (ch1.equalsIgnoreCase("YES"));

				break;
			}
			}

			System.out.println("\n\nDO YOU WANT TO CONTINUEEE IN OTHER BANKINGS  ..... PRESS YES !!!");

			choice = sc.next();

		} while (choice.equalsIgnoreCase("yes"));

	}
}
