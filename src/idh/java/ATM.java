package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ATM {
	HashMap<Integer, Integer> bankaccount = new HashMap<Integer, Integer>();
	int ATMCash = 1000;
	public ATM() {
		bankaccount.put(123, 666);
		bankaccount.put(361, 420);
		bankaccount.put(169, 67);
	}
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
					int accountnumber = Integer.parseInt(br.readLine());
				if (bankaccount.containsKey(accountnumber)) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(accountnumber, amount);
					}
				else {
					System.out.println("Sorry, This account number doesn't exist");
					}
				} 	catch (Exception e) {
						break;
			}
		}
	}

	public void cashout(int accountnumber, int amount) {
		int accountBalance = bankaccount.get(accountnumber);
			
			if (amount > accountBalance) {
				System.out.println("Sorry, not enough money in the bank.");
				return;
		}	
				
			if (amount > ATMCash){
				System.out.println("Sorry, not enough money in the ATM.");
				return;
		}
		accountBalance = accountBalance - amount;
		ATMCash = ATMCash - amount;
			bankaccount.put(accountnumber, accountBalance);
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

