package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	ATMcontroll[] accounts;
	int ATMbalance = 500;
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	public void run() {
		accounts();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Please enter your PIN: ");
				int PIN = Integer.parseInt(br.readLine());
				if (controllPIN(PIN)) {
					System.out.println("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount, PIN);
				}
				else {
					System.out.println("Wrong PIN. Please try again: ");
					break;
				}
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public boolean controllPIN(int PIN) {
		for(int i = 0; i < accounts.length; i++) {
			if(this.accounts[i].getPIN() == PIN) {
				return true;
			}
		}
		return false;
	}

	public void cashout(int amount, int PIN) {
		int accountBalance = 0;
		ATMcontroll account = null;
		
		for (int i = 0; i < accounts.length; i++) {
			if(this.accounts[i].getPIN() == PIN) {
				account = this.accounts[i];
				accountBalance = this.accounts[i].getBalance();
			}
		}
		if(amount <= ATMbalance && amount <= accountBalance) {
			account.setBalance(accountBalance - amount);
			ATMbalance = ATMbalance - amount;
			System.out.println("Please take the banknotes out of the cash withdrawal.");
		}
		else if(amount > accountBalance) {
			System.out.println("Not enough money in your bank account.");
		}
		else if(amount > ATMbalance) {
			System.out.println("Not enough money in the ATM. Please try another ATM.");
		}
	};
	
	public void accounts() {
		this.accounts = new ATMcontroll[5];
		this.accounts[0] = new ATMcontroll(500, 111);
		this.accounts[1] = new ATMcontroll(245, 222);
		this.accounts[2] = new ATMcontroll(933, 333);
		this.accounts[3] = new ATMcontroll(100, 444);
		this.accounts[4] = new ATMcontroll(799, 555);
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
