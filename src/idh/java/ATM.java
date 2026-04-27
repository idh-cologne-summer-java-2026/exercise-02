package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int bankBalance = 1000;
	int accountBalance = 100;


	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};


	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
