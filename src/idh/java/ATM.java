package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	int ATMBalance = 1000;

	int idex;
	
	int[] accountBalance = {500, 500, 500};

	int[] accounts = {123, 444, 561};

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
        @SuppressWarnings("UseSpecificCatch")
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("Enter your Account ID");
				int ID = Integer.parseInt(br.readLine());
				if (checkaccount(ID)) {
					System.out.println("Account Balance: " + accountBalance[idex]);
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount);
				} else {
					System.out.println("Unknown ID");
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount <= accountBalance[idex] && amount <= ATMBalance && amount != 0) {
			accountBalance[idex] = accountBalance[idex] - amount;
			ATMBalance = ATMBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if (amount > accountBalance[idex]) {
			System.out.println("BROKE.");
		} else if (amount > ATMBalance) {
			System.out.println("Sorry, not enough money in this bankmachine.");
		} else if (amount == 0) {
			System.out.println("Operation cancelled");
		}

	};

	public boolean checkaccount(int id) {
		boolean r = false;
		for (idex = 0; idex < accounts.length; idex++) {
			if (id == accounts[idex]) {
				r = true;
				break;
			}
		}
		return r;
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
