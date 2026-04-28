package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM {
	Customer selectedCustomer;
	int disposableCash = 1700;
	
	
	public void run(Customer[] customersArray) {
		while (true) {
			int accountNumber = queryAccount();	
			selectedCustomer = null;
			for (int i = 0; i < customersArray.length; i++) { 
				if (customersArray[i].getAccountNumber() == accountNumber) {
					selectedCustomer = customersArray[i];
					break;
				}
			}
			if (selectedCustomer != null) {
					int amount = queryAmount();
					cashout(selectedCustomer, amount);
				} else {
					System.out.println("The account number you have entered doesn't exist. Please try again.");
			}
		}
	}
	
	public int queryAccount() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				return accountNumber;
			} catch (Exception e) {
				System.out.println("Invalid entry. Please try again!");
				}
			}
	}
	
	public int queryAmount() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
				try {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					return amount;
				} catch (Exception e) {
					System.out.println("Invalid entry. Please try again!");
				}
		}
		}

	 
	public void cashout(Customer selectedCustomer, int amount) {
		if (amount > disposableCash) {
				System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		} else { 			
				int selectedCustomerBalance[] = selectedCustomer.getCustomerBasics();
				if (amount <= selectedCustomerBalance[1]) {
					this.disposableCash = disposableCash - amount;
					int accountBalance = selectedCustomerBalance[1] - amount;
					selectedCustomer.setAccountBalance(accountBalance);
					System.out.println("Ok, here is your money, enjoy!");
				} else {
					System.out.println("Sorry, not enough money in your bank account.");
				}
		}
	}

	public static void main(String[] args) {
		Customer[] customersArray = new Customer[2];
		customersArray[0] = new Customer(123, 500);
		customersArray[1] = new Customer(456, 1500);
		ATM atm = new ATM();
		atm.run(customersArray);
	};

}
