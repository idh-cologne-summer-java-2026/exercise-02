package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class ATM {
	int kontostand = 500;
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
		if (kontostand >= amount && amount > 0){
			kontostand -= amount;
			System.out.println("Here is your money: " + amount +"EUR. Enjoy! Your current balance is: " + kontostand +"EUR.");
		}
		else {
			System.out.println("Sorry, that is not possible. Please enter a valid amount to withdraw. Your current balance is: " + kontostand +"EUR.");
		}
	};
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};
