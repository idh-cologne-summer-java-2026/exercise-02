package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	int ATMbalance = 300000;
	int[] accBalance = {2000, 3000, 4000};
	int[] accNum = {123, 234, 345}; //somehow connect both arrays? multidimensional array?
	
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
				System.out.println("Enter your account number: ");
				int accNum = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) { 
		int i = ; //stuck here
		if (ATMbalance < amount) {
			System.out.println("Sorry the ATM doesn't have that much cash anymore");
			break;
		}
		if (amount < accountBalance) {
			accBalance[i] = accBalance[i] - amount;
			ATMbalance = ATMbalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
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
