package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import idh.java.Account;
/**
 * Main command loop of the ATM Asks the user to enter a number, and passes this
 * number to the function cashout(...) which actually does the calculation and
 * produces money. If the user enters anything else than an integer number, the
 * loop breaks and the program exists
 * 
 * Aufgabe 1: Der Automat sollte verschiedene Konten verwalten können. D.h. dass Benutzer:innen 
 * im Dialog zunächst ihre Kontonummer angeben müssen, und danach den Betrag. Der Geldautomat 
 * weiß dann für alle inviduellen Benutzer:innen, wie viel Geld diese noch auf dem Konto haben. 
 * Dafür brauchen Sie eine passende Datenstruktur, also z.B. ein Array.
 * 
 * Lösungsansatz: Ein array erstellen, welches die Kontonummern und die Beträge enthält. Klasse?  
 * 
 * Aufgabe 2: Der Automat verwaltet außerdem, wie viel Bargeld er noch zur Verfügung hat. D.h. 
 * auch wenn eine Benutzerin genug Geld auf dem Konto hat, kann es sein, dass sie das Geld nicht 
 * bekommt, weil der Automat leer ist. Wenn eine Auszahlung passiert ist, sollte der Automat seinen 
 * Bargeldbestand jeweils aktualisieren.
 * 
 * Lösungsansatz: ATMcash? 
 * 
 * Beispiel: 
 * Enter your account number: 123
 * Enter the amount to withdraw: 21
 * Ok, here you go!
 * Enter your account number: 234
 * Enter the amount to withdraw: 452
 * Sorry, you don't have enough money in the bank.
 * Enter your account number: 345
 * Enter the amount to withdraw: 56
 * Sorry, the ATM doesn't have that much cash anymore.
 */

public class ATM {
	
	Account[] accounts = {
		    new Account(1001, 500),
		    new Account(1002, 1200),
		    new Account(1003, 300)
		};
	
	int ATMcash = 1000;
	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			try {
			 	System.out.print("Enter your account number:  ");
				int accountNumber = Integer.parseInt(br.readLine());
				
				System.out.print("Enter the amount to withdraw:  ");
				int amount = Integer.parseInt(br.readLine());
				
				cashout (accountNumber, amount);
				
			} catch (NumberFormatException e) {
				System.out.println("Wrong input. Please provide an integer number"); /* Mit dieser exception
				können keine Kommazahlen eingegeben werden*/ 
			} catch (IOException e) {
					 System.out.println("There ia an IO problem. Please call a technian");
					}
				break; // break beendet die Schleife vollständig
				} 
			}
		
		

	public void cashout(int accountNumber, int amount) {
		Account account = findAccount (accountNumber);
				if (account == null) {
	            System.out.println("Sorry, account not found.");
	            return;
			} else if (amount > account.accountBalance) {
	            System.out.println("Sorry, you don't have enough money on your account.");
	            return;
	        } else if (amount > ATMcash) {
	            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
	            return;
	        }

	        account.accountBalance = account.accountBalance - amount;
	        ATMcash = ATMcash - amount;

	        System.out.println("Ok, here you go!");
	    }

		
		
	
	
	public Account findAccount(int accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].accountNumber == accountNumber) {
                return accounts[i];
            }
        }

        return null;
    }

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
