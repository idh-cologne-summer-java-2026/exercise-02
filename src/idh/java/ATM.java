package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 5000;
	int accountBalance = 0;
	int savedAccountNumbers[];
	int accountBalances[];
	int savedAccountNumber; // Track the currently logged-in account
	
	// Constructor to initialize the arrays
	public ATM() {
		savedAccountNumbers = new int[100];  // Space for up to 100 accounts
		accountBalances = new int[100];
	}
	
	//Here shall be the Declaration of the account
	public void accountDeclaration(int accountNumber) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter your accountNumber: ");
			accountNumber = Integer.parseInt(br.readLine());
		} catch (Exception e) {
		}
		for(int i = 0; i < savedAccountNumbers.length; i++) {
			if(savedAccountNumbers[i] == accountNumber) {
				// Account found
				savedAccountNumber = accountNumber;
				accountBalance = accountBalances[i];
				break;
			}
            else {
                // Account not found, add it to the list
                savedAccountNumbers[i] = accountNumber;
                accountBalances[i] = 0;
                savedAccountNumber = accountNumber;
                accountBalance = 0;
                break;
            }
		}
		
	}
	
	public void add(int newAmount) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the Amount you want to add: ");
			newAmount = Integer.parseInt(br.readLine());
		} catch (Exception e) {
		}
		// Find the index of the current account and update its balance
		for(int i = 0; i < savedAccountNumbers.length; i++) {
			if(savedAccountNumbers[i] == savedAccountNumber) {
				accountBalances[i] = accountBalances[i] + newAmount;
				accountBalance = accountBalances[i];
				System.out.println("New balance: " + accountBalance);
				break;
			}
		}
	}
		

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. Exits after one withdrawal.
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Enter the amount to withdraw: ");
			int amount = Integer.parseInt(br.readLine());
			cashout(amount);
			// After one withdrawal, restart the full cycle
			accountDeclaration(0);
			add(0);
			run();
		} 
		catch (Exception e) {
			// Exit on error
		}
	}
		

	public void cashout(int amount) {
		// Check if ATM has enough money
		if (atmBalance < amount) {
			System.out.println("Error: ATM does not have enough money. Please contact the owner.");
			return;
		}
		
		// Check if account has enough money
		if (amount > accountBalance) {
			System.out.println("Sorry, not enough money in your account.");
			return;
		}
		
		// Process the withdrawal
		accountBalance = accountBalance - amount;
		atmBalance = atmBalance - amount;
		
		// Save the updated balance back to the array
		for(int i = 0; i < savedAccountNumbers.length; i++) {
			if(savedAccountNumbers[i] == savedAccountNumber) {
				accountBalances[i] = accountBalance;
				break;
			}
		}
		
		System.out.println("Ok, here is your money, enjoy!");
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.accountDeclaration(0);
		atm.add(0);
		atm.run();
	};
}