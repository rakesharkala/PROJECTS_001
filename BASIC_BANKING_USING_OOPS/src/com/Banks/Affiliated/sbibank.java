package com.Banks.Affiliated;

import com.main.*;

// FOR SBI INFO

abstract class SBI implements BANKING_M {
	int total, it;
	int minbalance;
	int a;
}

public class sbibank extends SBI {

	@Override
	public void user_info(String name, int accno, String address) {
		System.out.println("\n\n=================================================================================");
		minbalance = 1000;
		System.out.println("USER NAME : " + name.toUpperCase());
		System.out.println("USER ACCOUNT NO : " + accno);
		System.out.println("USER ADDRESS : " + address);
		System.out.println("\n\nUR AVALABLE BALANCE " + total + "   MININIMUM BAL EXCLUDED : " + minbalance);

		System.out.println("\n\n=================================================================================");

	}

	public void add_money(int am) {

		total = total + am;

		System.out.println("YOUR MONEY CREDITED SUCCESSFULLY ....");
		System.out.println("\n\n=================================================================================");

	}

	@Override
	public void withdrals(int w) {

		if (w < total && w > 100 && w < 100000) {
			total = total - w;
			System.out.println("YOUR MONEY WITHDRAWL IS SUCCESFULL ....!!!");
		} else if (w < 100) {
			System.out.println("YOU HAVE PRECEDEED MIN LIMIT ...MIN AMOUNT 100.00");
		} else if (w > 100000) {
			System.out.println("YOU HAVE EXCEEDED MAXIMUM LIMIT ...MAX LIMIT 100000.00");
		} else {
			System.out.println("YOU HAVE INSUFFICINT BALANCE ...");
		}
		System.out.println("\n\n=================================================================================");

	}

	@Override
	public void loan_intrest(int m, int y) {
		int t = 0;

		if (m >= 50000 && m <= 500000 && y >= 1 && y <= 10) {
			it = 5;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");

		} else if (m < 50000 && y >= 1 && y <= 10) {
			it = 14;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");
		} else if (m > 500000) {
			it = 10;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");

		} else if (y > 10) {
			System.out.println("LOAN IS NOT APPORVED .... WE R SORRY FOR INCONVINENCE");
		}
		System.out.println("\n\n=================================================================================");

	}

	@Override
	public void crop_loan(int m, int y) {
		int t = 0;

		if (m >= 50000 && m <= 500000 && y >= 1 && y <= 10) {
			it = 4;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");

		} else if (m < 50000 && y >= 1 && y <= 10) {
			it = 7;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");
		} else if (m > 500000) {
			it = 11;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");

		} else if (y > 10) {
			System.out.println("LOAN IS NOT APPORVED .... WE R SORRY FOR INCONVINENCE");
		}
		System.out.println("\n\n=================================================================================");

	}

	@Override
	public void gold_loan(int m, int y) {
		int t = 0;

		if (m >= 50000 && m <= 500000 && y >= 1 && y <= 10) {
			it = 4;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");

		} else if (m < 50000 && y >= 1 && y <= 10) {
			it = 9;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");
		} else if (m > 500000) {
			it = 10;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");

		} else if (y > 10) {
			System.out.println("LOAN IS NOT APPORVED .... WE R SORRY FOR INCONVINENCE");
		}
		System.out.println("\n\n=================================================================================");

	}

	@Override
	public void home_loan(int m, int y) {
		int t = 5;

		if (m >= 50000 && m <= 500000 && y >= 1 && y <= 10) {
			it = 2;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");

		} else if (m < 50000 && y >= 1 && y <= 10) {
			it = 5;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");
		} else if (m > 500000) {
			it = 15;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");

		} else if (y > 10) {
			System.out.println("LOAN IS NOT APPORVED .... WE R SORRY FOR INCONVINENCE");
		}
		System.out.println("\n\n=================================================================================");

	}
}
