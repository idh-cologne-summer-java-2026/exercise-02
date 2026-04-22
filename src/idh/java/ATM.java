package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	
	// Geldbestand des Automaten
	int ATMBalance = 1000;
	
	
	// Kontonummern und die dazugehörogen Ständen werden in zwei einzelnen Arrays deklariert
	int[] Kontonummern = {13342, 14432, 15434, 65466, 76543};
	int[] Kontostände = {200, 100, 500, 700, 900};
	
	

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
				
				System.out.println("Kontonummer eingeben:");
				int KontonummerInput = Integer.parseInt(br.readLine());
				
				
				
				
				
				int lastIndex = -1; // Das Array Kontonummern soll bis zur letzten Stelle durchsucht werden
				
				for (int i = 0; i < Kontonummern.length; i++) {
					if (Kontonummern[i] == KontonummerInput) {
						lastIndex = i; //Position speichern
						break; 
					}
					
				}
				
				
				
				
				// Fallback Option: Wenn die Kontonummer immer noch bei -1 ist, dann war die Eingabe falsch
				if (lastIndex == -1) {
					System.out.println("Invalid account number. Please try again.");
					continue; 
				} 
				
				//Kontostand für den Index anzeigen lassen
				System.out.println("Kontostand:" + Kontostände[lastIndex]);
				
				// Am Geldautomaten verfügbarer Betrag
				System.out.println("Verfügbar:" + ATMBalance);
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(lastIndex, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int lastIndex, int amount) {
		if (amount > ATMBalance) {
			System.out.println("Der Automat hat nicht, genug Geld, bite später versuchen");
			return;
		}
		
		
		// Wenn der eingegebene Betrag kleiner ist als der Kontostand am Index, dann wird das Geld abgebucht
		if (amount <= Kontostände[lastIndex] && amount <= ATMBalance) { 
			
			Kontostände[lastIndex] -= amount;// abgehobenen Betrag am Index abziehen
			ATMBalance -= amount;  // abgehobenen Betrag vom Geldautomaten abziehen
			
			System.out.println("Ok, here is your money, enjoy!");
			
		// Unterscheidung zwischen nich genug Geld am Index oder nicht genug Geld im Automaten	
		} else if (amount > Kontostände[lastIndex]){
			System.out.println("Nicht genug Geld auf dem Konto");
			
		} else if (amount > ATMBalance) {
			System.out.println("Geldautomat leer");
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
