package idh.java;
import java.io.*;

public class ATM {
	int[] kontostaende = new int[100]; // Accounts von 1-99
	int geldImAutomat = 350;
	int accountNumber;
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything that cannot be converted to an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.println("Enter your account number: ");
				accountNumber = Integer.parseInt(br.readLine());
				if (accountNumber < 1 || accountNumber >= 100) {
					System.out.println("Invalid account number. Please enter a number between 1 and 99.");
					continue;
				}
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
				//verschiedene catch Blöcke zum Abfangen unterschiedlicher Fehler
			} catch (NumberFormatException e) { //falscher Datentyp eingegeben
				System.out.println("Invalid input. Try again.");
				//break; auskommentiert, weil ein fehlerhafter Input dem User gesagt werden soll und eine neuer Input gewünscht ist.
			}
			  catch (IOException e) { //Fehler beim Lesen der Eingabe
				System.out.println("An IO error occurred. Try again.");
			}
		}
	}
	
	public void cashout(int amount) {
		//Sicherstellung, dass die Beträge des Abhebens und des Geldes im Automaten zu einer (für den User) positiven Ausgabe führen
		if (amount <= 0) {
			System.out.println("Please enter a positive amount.");
			return;
		}
		if (amount > geldImAutomat) {
			System.out.println("Sorry, the ATM only has " + geldImAutomat + " EUR available. Please enter a valid amount to withdraw.");
			return;
		}
		if (kontostaende[accountNumber] < amount) {
			System.out.println("Sorry, that is not possible. Your current balance is: " + kontostaende[accountNumber] + " EUR. Please enter a valid amount to withdraw.");
			return;
		}
		kontostaende[accountNumber] -= amount;
		geldImAutomat -= amount;
		System.out.println("Here is your money: " + amount +"EUR. Enjoy! Your current balance is: " + kontostaende[accountNumber] +"EUR.");
	};
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		// hier wird für jedes Konto 500EUR festgelegt
		for(int i = 1; i < 100; i++) {
			atm.kontostaende[i] = 500;
		}
		atm.run();
	};
};
