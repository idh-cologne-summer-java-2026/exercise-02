package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	// ALT: int accountBalance = 100;
	// NEU: Ein Array für die Kontonummern, eins für den Kontostand und eins für den Automatenbestand
	int[] accounts = {123, 234, 345};
	int[] balances = {100, 100, 100};
	int atmCash = 50; // Der Automat startet mit 50 Geldeinheiten

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
				// NEU: Zuerst nach der Kontonummer fragen
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());

				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				
				// NEU: Beide Werte an cashout übergeben
				cashout(accountNumber, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	// NEU: Die Funktion nimmt jetzt Kontonummer UND Betrag
	public void cashout(int accountNumber, int amount) {
		// NEU: Position (Index) des Kontos im Array finden
		int index = -1;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == accountNumber) {
				index = i;
			}
		}

		// ALT: if (amount < accountBalance) ...
		// NEU: Die neuen Bedingungen prüfen
		if (amount > balances[index]) {
			System.out.println("Sorry, you don't have enough money in the bank.");
		} else if (amount > atmCash) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		} else {
			// Geld wird von beiden abgezogen
			balances[index] = balances[index] - amount;
			atmCash = atmCash - amount;
			System.out.println("Ok, here you go!");
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
