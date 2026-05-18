package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

    int atmCredit = 100;
    Konto[] accounts;

    /**
     * Main command loop of the ATM
     */
    public void run() {
        accounts();//accounts are made here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int number = Integer.parseInt(br.readLine());

                if (checkNumber(number)) {
                    System.out.print("Enter the amount to withdraw: ");
                    int amount = Integer.parseInt(br.readLine());
                    cashout(amount, number);
                } else {
                    System.out.println("Sorry, that account doesn't exist.");
                }

            } catch (Exception e) {
                break;
            }
        }
    }

    /**
     * Checks whether an account with the given number exists
     */
    public boolean checkNumber(int number) {
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i].getNumber() == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Withdraws money from a specific account
     */
    public void cashout(int amount, int number) {
        int accountCredit = 0;
        Konto account = null;

        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i].getNumber() == number) {
                account = this.accounts[i];
                accountCredit = this.accounts[i].getCredit();
            }
        }

        if (amount <= 0) {
            System.out.println("Please enter a positive amount.");
        } else if (amount <= atmCredit && amount <= accountCredit) {
            account.setCredit(accountCredit - amount);
            atmCredit = atmCredit - amount;
            System.out.println("Ok, here you go!");
        } else if (amount > accountCredit) {
            System.out.println("Sorry, you don't have enough money in the bank.");
        } else if (amount > atmCredit) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        }
    }

    /**
     * Creates example accounts
     */
    public void accounts() {
        this.accounts = new Konto[3];
        this.accounts[0] = new Konto(100, 123);
        this.accounts[1] = new Konto(400, 234);
        this.accounts[2] = new Konto(1000, 345);
    }

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}