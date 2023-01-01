package com.Banks.Affiliated;

public interface BANKING_M {

	public void user_info(String name, int accno, String addrass); // ABSTRACT METHODS

	public void withdrals(int n);

	public void loan_intrest(int m, int y);

	public void crop_loan(int m, int y);

	public void gold_loan(int m, int y);

	public void home_loan(int m, int y);

	public void add_money(int m);

}
