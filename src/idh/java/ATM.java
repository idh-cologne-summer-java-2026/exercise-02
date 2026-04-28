package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int[] accountBalances = new int[] {100, 1000, 10000};

	int storage = 500;
	
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
			} catch (NumberFormatException e) {
				System.err.println("This wasn't a number. Try again!");
			} catch (Exception e) {
				break;
			}
		}
	}

	
	public void cashout(int accountNumber, int amount) {
		if (amount > storage) {
			System.err.println("Sorry, the ATM is out of cash.");
			return;
		}
		if (amount > accountBalances[accountNumber]) {
			System.out.println("Sorry, you're out of money.");
			return;
		}
		accountBalances[accountNumber] = accountBalances[accountNumber] - amount;
		storage = storage - amount;
		System.out.println("Ok, here is your money, enjoy!");
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
