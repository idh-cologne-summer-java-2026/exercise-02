package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int[] accountBalances = new int[1000];
	int atmCashReserve = 500;
	
	public ATM() {
		accountBalances[123] = 100;
		accountBalances[234] = 300;
		accountBalances[345] = 1000;
	}

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		
		if (accountNumber < 0 || accountNumber >= accountBalances.length)
			System.out.println("Invalid account number.");
		return;
		
	
	
	
	if (amount > accountBalances[accountNumber]) {
			System.out.println("Sorry, you don´t have enough money in the bank."); }
			else if (amount > atmCashReserve) {
			System.out.println("Sorry, the ATM doesn´t have that much cash anymore.");
		} else {
		
			
		}	accountBalances[accountNumber] -= amount;
			atmCashReserve -= amount;
	System.out.println("Ok, here you go!"); {
		}
		

		

	

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
