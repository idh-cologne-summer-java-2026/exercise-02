package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

    int bankBalance = 10000;

    Account[] accounts = {
        new Account(123, 1500),
        new Account(456, 2300),
        new Account(789, 800)
    };

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Enter account number: ");
                int accountNumber = Integer.parseInt(br.readLine());

                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());

                cashout(accountNumber, amount);

            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {
    	
        Account account = findAccount(accountNumber);


        if (amount > account.accountBalance) {
            System.out.println("Sorry, not enough money on your account.");
        }

        if (amount > bankBalance) {
            System.out.println("Sorry, not enough money in the ATM.");
        }

        account.accountBalance = account.accountBalance - amount;
        bankBalance = bankBalance - amount;

        System.out.println("Ok, here is your Money!");
        System.out.println("New account balance: " + account.accountBalance);
    }

    public Account findAccount(int accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].accountNumber == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}