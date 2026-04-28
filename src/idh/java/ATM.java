package idh.java;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class ATM {
	private List<Integer> bankAccounts = new ArrayList<>();
	private int accountBalance;
	int ATMBalance = 20000;
	private int accountNumber;
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
				int accountNumber = Integer.parseInt(br.readLine());
				accountmanager(accountNumber);
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount < accountBalance || amount < ATMBalance) {
			accountBalance = accountBalance - amount;
		    ATMBalance = ATMBalance - amount;
			System.out.println("Ok, here is your money, enjoy! Your current Balance is: " + accountBalance );
		} else if (amount > accountBalance){
			System.out.println("Sorry, not enough money in the bank.");
		} else {
			System.out.println("Sorry, the ATM doesnt have that much cash anymore");
		}
	
	};
	public void accountmanager(int accountNumber) {
	    accountNumber = this.accountNumber;
	    accountNumber = this.accountBalance = 1000;
	    bankAccounts.add(accountNumber);
	    
	    
     }

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
