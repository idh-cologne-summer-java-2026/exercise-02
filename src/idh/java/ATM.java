package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int[] balances = new int[]{150, 200, 325, 670};
	int moneyInATM = 1000;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.println("Enter your account number: ");
				int accountID = Integer.parseInt(br.readLine());
				accountID = accountID - 1; 
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accountID);
			} catch (Exception e) {
				break;
			}
		}
	}
	

	public void cashout(int amount, int accountID) {
		if(amount <= moneyInATM) {
			if (amount <= balances[accountID]) {
				balances[accountID] = balances[accountID]- amount;
				System.out.println("Ok, here is your money, enjoy!");
				moneyInATM = moneyInATM - amount;
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}
		} else {
			System.out.println("Sorry, the ATM doesn't have enough cash.");
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
