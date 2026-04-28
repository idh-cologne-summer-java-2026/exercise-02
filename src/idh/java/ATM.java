package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	Account[] accounts = new Account[5]; 
	

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public ATM() {
		for(int i=0; i<accounts.length; i++) {
			accounts[i]= new Account(i,500); 
		}
	}
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: "); 
				int accNum = Integer.parseInt(br.readLine()); 
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accNum,amount);
			} catch (Exception e) {
				break;
			}
		}
	}
	protected Account getAccount(int accNum) {
		for(int i=0; i<accounts.length; i++) {
		  if(accounts[i].getAccNum()== accNum) {
			return accounts[i]; 
		  }
		}
		return null; 
	}

	public void cashout(int accNum, int amount) {
		Account account = getAccount(accNum); 
		if(account == null) {
			System.out.println("Account doesn't exist"); 
			return; 
		}
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
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
