package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	static int [] accountBalance = new int [3];
	int bankBalance = 2000;
	int activeUser;

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
				boolean repeat = false;
				do {
					repeat = false;
				    System.out.print("Enter your account number: ");
    				int input = Integer.parseInt(br.readLine());
	    			if (input == 123) {
		    			activeUser = 0;
			    	}
			    	else if (input == 234) {
				    	activeUser = 1;
	    			}
		    		else if (input == 345) {
			    		activeUser = 2;
    				}
	    			else {
	    				System.out.println("There is no account with that number. Try again.");
			    		repeat = true;
	    			}
			   	}
				while (repeat);
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount > bankBalance) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		}
		else if (amount <= accountBalance[activeUser]) {
			accountBalance[activeUser] = accountBalance[activeUser] - amount;
			bankBalance = bankBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		}
		else System.out.println("Sorry, not enough money in your account.");
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		accountBalance[0] = 1000;
		accountBalance[1] = 200;
		accountBalance[2] = 2000;
		ATM atm = new ATM();
		atm.run();
	};

}