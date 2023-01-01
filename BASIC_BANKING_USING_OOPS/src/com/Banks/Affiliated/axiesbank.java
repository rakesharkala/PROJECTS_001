package com.Banks.Affiliated;

abstract class axies1 implements BANKING_M {
	int total, it;
	int minbalance;
	int a;
}

public class axiesbank extends axies1 {

	public void user_info(String name, int accno, String addrass) {

	}

	public void add_money(int am) {
	}

	@Override
	public void withdrals(int w) {
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
		System.out.println("\n========================================================\n");

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
		System.out.println("\n========================================================\n");

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
		System.out.println("\n========================================================\n");

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
			it = 22;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");
		} else if (m > 500000) {
			it = 17;
			a = (m * it * y) / 100;
			t = m + a;
			System.out.println("RATE OF INTREST WE ARE PROCESSING  -- " + it + "%");
			System.out.println("THE INTREST  APPLICABLE ON YOUR PROCESS " + a);
			System.out.println("\nTOTAL AMOUNT REPAYBLE " + (m + a) + ".00");

		} else if (y > 10) {
			System.out.println("LOAN IS NOT APPORVED .... WE R SORRY FOR INCONVINENCE");
		}
		System.out.println("\n========================================================\n");

	}
}