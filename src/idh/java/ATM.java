package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	/**
	 * This array stores the balances of different accounts, which are identified by
	 * their index position. I.e., in this implementation, account numbers are from
	 * 0 to 2.
	 */
	int[] accountBalances = new int[] { 100, 1000, 10000 };

	/**
	 * How much money does the ATM have stored. This is a simplification compared to
	 * the real world, because we're not distinguishing between different kinds of
	 * bills.
	 */
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
				// Ask the user for their account number
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());

				// Ask for amount to withdraw from account
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());

				// Call cashout function
				cashout(accountNumber, amount);
			} catch (NumberFormatException e) {
				System.err.println("This wasn't a number. Try again!");
			} catch (Exception e) {
				break;
			}
		}
	}

	/**
	 * The cashout function checks if both ATM and account have enough money and
	 * produces bills on the command line. It also subtracts the money from ATM and
	 * account.
	 * 
	 * This function is implemented in a "fail-first" manner: We first check if all
	 * preconditions are met, and exit the function prematurely, if one of the
	 * preconditions are not met (i.e., we call <code>return</code>. If the code
	 * reaches the bottom three lines of the function, we know that the withdrawal
	 * is valid (because otherwise we would not have reached this line).
	 * 
	 * @param accountNumber
	 * @param amount
	 */
	public void cashout(int accountNumber, int amount) {
		if (amount > storage) {
			System.err.println("Sorry, the ATM is out of cash.");
			return; // we return without value, because it's a void function
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
