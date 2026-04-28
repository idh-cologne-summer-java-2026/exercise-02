package idh.java;

import java.util.Arrays;

public class Customer {
	private int accountNumber;
	private int accountBalance;
	
	Customer(int accountNumber, int accountBalance) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;		
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public int[] getCustomerBasics() {
		int customerBasics[] = new int[]{this.accountNumber, this.accountBalance};
		return customerBasics; 
	}
	
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
}

