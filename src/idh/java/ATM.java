package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ATM {
	
	// 1. Bargeldbestand des Automaten
	int atmCash = 500; 
	
	// 2. Datenstruktur für Konten: Key = Kontonummer, Value = Kontostand
	HashMap<Integer, Integer> accounts = new HashMap<>();

	// Konstruktor, um Startwerte für die Test-Konten festzulegen
	public ATM() {
		accounts.put(123, 100);
		accounts.put(234, 300);
		accounts.put(345, 1000);
	}

	/**
	 * Main command loop of the ATM
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				// 3. Zuerst die Kontonummer abfragen
				System.out.print("Enter your account number: ");
				String accInput = br.readLine();
				// Falls "exit" eingegeben wird, beenden
				if (accInput.equalsIgnoreCase("exit")) break;
				int accNumber = Integer.parseInt(accInput);

				// 4. Dann den Betrag abfragen
				System.out.print("Enter the amount to withdraw: ");
				String amountInput = br.readLine();
				if (amountInput.equalsIgnoreCase("exit")) break;
				int amount = Integer.parseInt(amountInput);

				// 5. Logik-Methode mit BEIDEN Werten aufrufen
				cashout(accNumber, amount);

			} catch (Exception e) {
				// Bricht ab, wenn etwas anderes als eine Zahl eingegeben wird
				break;
			}
		}
	}

	public void cashout(int accNumber, int amount) {
		// Prüfen, ob das Konto existiert
		if (!accounts.containsKey(accNumber)) {
			System.out.println("Account not found.");
			return;
		}

		int userBalance = accounts.get(accNumber);

		// Check 1: Hat der Nutzer genug Geld?
		if (amount > userBalance) {
			System.out.println("Sorry, you don't have enough money in the bank.");
		} 
		// Check 2: Hat der Automat genug Geld?
		else if (amount > atmCash) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		} 
		// Erfolg: Geld kann ausgegeben werden
		else {
			accounts.put(accNumber, userBalance - amount); // Nutzerkonto belasten
			atmCash -= amount; // Automatenbestand reduzieren
			System.out.println("Ok, here you go!");
		}
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}
}