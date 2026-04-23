package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int totalReserve = 10000; 
	int[] accounts = new int[] {10000, 5000, 1000}; 

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
				System.out.print("Enter your account id");
				int accountId = Integer.parseInt(br.readLine());
				int accountBalance = accounts[accountId]; 
				System.out.print("You currently have " + accounts[accountId] + " In your Bank account");
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				
				cashout(amount, accountId);

			} catch (Exception e) {
				break;
			}
		}
	}
	public void cashout(int amount, int accountId) {
		if(totalReserve < amount)
		{ System.out.println("not enough money in this device");}
		if (amount <= accounts[accountId]) {
			accounts[accountId] = accounts[accountId] - amount;
			System.out.println("Ok, here is your money, enjoy!");
			System.out.println("You have " + accounts[accountId] + "$ left in your account");
		} else {
			System.out.println("Sorry, not enough money in the your bank.");
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
