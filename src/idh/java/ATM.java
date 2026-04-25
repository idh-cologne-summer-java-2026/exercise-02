package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {

	int ATMBalance = 1000;
	int[] Kontonummern = {1234, 2345, 3456, 4567, 5678};
	int[] Kontostände ={777, 333, 969, 67, 420};
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

				System.out.println("Sgeden , Was Nummer?");
				int KontonummerInput = Integer.parseInt(br.readLine());

				int lastIndex = -1; 
				for (int i = 0; i < Kontonummern.length; i++) {
					if (Kontonummern[i] == KontonummerInput) {
						lastIndex = i; 
						break; 
					}
				}
					if (lastIndex == -1) {
					System.out.println("oh schade die gibts nicht nummer. Please try again.");
					continue; 
				} 
				System.out.println("Dein geld !:" + Kontostände[lastIndex]);

				System.out.println("Verfügbar:" + ATMBalance);
		
				System.out.println("was willst du abheben: ");
				int amount = Integer.parseInt(br.readLine());
					cashout(lastIndex,amount);
			} catch (IOException | NumberFormatException e) {
				break;
			}
		}
	}

	public void cashout(int lastIndex, int amount) {
		if (amount  > ATMBalance) {
			System.out.println("Der Automat IST ARM ; später versuchen");
			return;
		}
		
		
		if (amount <= Kontostände[lastIndex] && amount <= ATMBalance) { 
			
			Kontostände[lastIndex] -= amount;
			ATMBalance -= amount;  
			
			System.out.println("Ok, here is your money, enjoy!");
			
		
		} else if (amount > Kontostände[lastIndex]){
			System.out.println("Nicht genug Geld auf dem Konto, denk mal drüber nach");
			
		} else if (amount > ATMBalance) {
			System.out.println("Geldautomat leergefegt");
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
