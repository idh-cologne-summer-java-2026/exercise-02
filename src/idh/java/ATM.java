package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	int[] accounts = {1000, 250, 3000, 50};
	int accountID;
	int cash = 650;
	
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
				
				
				while(true) {
					
					try {
						System.out.print("Enter your account ID: ");
						accountID = Integer.parseInt(br.readLine());
						if(accountID >= accounts.length) {
							System.out.println("Account does not exist, please try again.");
							
						}
						if(accountID < accounts.length) {
							break;
						}
						
					}catch (Exception e) {
						break;
					}
					
				}  		
				
				System.out.println("Your Balance is: " + accounts[accountID]);
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accountID);
				
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int accountID ) {
		
		if(amount <= cash) {
			
			if (amount <= accounts[this.accountID]) {	
			accounts[this.accountID] = accounts[this.accountID] - amount;
			cash = cash - amount;
			System.out.println("Ok, here is your money, enjoy!");
			} else {
			System.out.println("Sorry, not enough money in the bank.");
			}
		} else {
			System.out.println("not enough cash in the ATM :(");
		}
	}

	/*
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
