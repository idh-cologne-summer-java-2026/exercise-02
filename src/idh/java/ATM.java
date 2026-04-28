package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
    int atmCredit =1;
    Konto [] accounts  = new Konto [3];
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		accounts (); //acounts are made here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println ("Welcome. Please, enter your account number");
				int number = Integer.parseInt(br.readLine());
				if (checkNumber (number)) {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout (amount, number);
				}else {
					System.out.println ("Sorry, this account doesn't exist.");
				}
	
			} catch (Exception e) {
				break;
			}
		}
	}
	private void accounts() {
		// TODO Auto-generated method stub
		
	}
	public boolean checkNumber (int number) // see if an account with this number exists
	{
		for (int i =0; i< this.accounts.length; i++) {
			if (this.accounts[i].getNumber () == number ) {
			 return true;
			} 
			 }
				return false;	
	}
	public void cashout(int amount, int number) {
		int accountCredit = 0; // credit of the account that corresponds to number
		Konto account = null; // just a variable to save the account found

		for (int i =0; i < accounts.length; i++) {
			accounts[i] = new Konto (i, amount);}
			// search for the rigth accounts credit
		if (amount <= accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if (amount> atmCredit){
			System.out.println("Sorry, the ATM doesn't have enough money");
		}
		
		else {
			System.out.println("Sorry, you don't have enough money in the bank.");
		}
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
