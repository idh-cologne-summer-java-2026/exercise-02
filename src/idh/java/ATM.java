package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	// aktuell
	int cash = 1000;
	account[] accounts;
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		int aNr = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter Account Number: ");
				aNr = Integer.parseInt(br.readLine());
				if (checkANr(aNr)) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					if (checkCash(amount) && accounts[aNr].abbuchen(amount)) {
					cashout(amount);
					}
				}
			}
			catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
			cash = cash - amount;
			System.out.println("Ok, here is your money, enjoy!");
	} 


	public boolean checkANr(int aNr){
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getAccountNr() == aNr) {
				return true;
			}
		}
		System.out.print("Wrong account number!");
		return false;
	}
	
	private boolean checkCash(int a) {
		if (a <= cash) {
			return true;
		}
		else {
			System.out.println("Sorry, not enough money in the ATM.");
			return false;
		}
	}
	
	private void setCash(int c) {
		cash = c;
	}
	
	
	// testet, ob der Automat wie vorgesehen reagiert, wenn kein Bargeld mehr vorhanden ist
	public void runTESTcashout() {
		setCash(0);
		int aNr = 0;
		while (true) {
			try {
				if (checkANr(aNr)) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = 1;
					if (checkCash(amount) && accounts[aNr].abbuchen(amount)) {
					cashout(amount);
					}
				}
				System.out.print("Der Test wurde durchgeführt");
				break;
			}
			catch (Exception e) {
				break;
			}
		}
	}	
		
	ATM(){
		accounts = new account[100];
		for (int i =  0; i < 100; i++) {
			accounts[i] = new account();
			accounts[i].setAccountNr(i);
		}
	}
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
//		atm.runTESTcashout();
	};

}
