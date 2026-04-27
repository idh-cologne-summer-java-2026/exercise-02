package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
	double accountBalance = 1000;
	User u1 = new User("Max"  , 1, 500);
	User u2 = new User("Marie", 2, 1740.5);
	User u3 = new User("Bernd", 3, 12345.75);
	User u4 = new User("Sarah", 4, 3000);
	User users[] = {u1,u2,u3,u4};
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 * @throws IOException 
	 */
	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter User-ID: ");
				int uId = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				double amount = Double.parseDouble(br.readLine());
				cashout(uId, amount);
			} catch (NumberFormatException e) { //throws NumberFormatException that should be handled
				System.err.print("Illegal input.");
				break;
			}
		}
	}

	public void cashout(int uId, double amount) {
			boolean found = false; //variable that turns false the moment an non-authorized command is entered to end the loop
		for(int i = 0; i < users.length; i++) {
			if(users[i].getId() == uId && users[i].getBalance() >= 0 && users[i].getBalance() - amount >= 0) {
			accountBalance = accountBalance - amount;
			users[i].setBalance(users[i].getBalance() - amount);//update user balance using getter and setters
			found = true;
			System.out.println("Ok, here is your money, enjoy! Current balance: " + users[i].getBalance());
			break; //break, otherwise the loop checks all accounts even after finding the matching id
		} 
		}
		/*if the Id is not found or there is no more/not enough money print an error message -> 
		 * This must be outside the loop to work otherwise the found variable turns false 
		 * no matter the result, preventing the rest of the array to be checked */
		if(found != true) { 
			System.err.println("No such Account or not enough money in the bank.");
			}
	};

	/**
	 * Launches the ATM
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		
		ATM atm = new ATM();
		atm.run();
	};

}
