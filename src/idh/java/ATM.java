package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmCash = 50;
	int[] accountNumbers = {123, 234, 345};
    int[] balances = {100, 200, 50};

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
                int accNum = Integer.parseInt(br.readLine());

                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());

                cashout(accNum, amount);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {
        int index = -1;

        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i] == accountNumber) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Sorry, account not found.");
            return;
        }

        if (amount > balances[index]) {
            System.out.println("Sorry, you don't have enough money in the bank.");
        } 

        else if (amount > atmCash) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        } 

        else {
            balances[index] -= amount;
            atmCash -= amount;
            System.out.println("Ok, here you go!");
        }
    }

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
