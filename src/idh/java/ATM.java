package idh.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int cash = 1000;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run(account[] Users){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accnum= Integer.parseInt(br.readLine());
				
				account User = null;
				for (int i = 0; i < Users.length; i++) {
				    if (Users[i].accountnumber == accnum) {
				        User = Users[i];
				        break;
				    }
				}
				
				    if (User != null) {
				System.out.println("aktueller Kontostand des Kontos " + 
				User.accountnumber+" : "  +User.balance);
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, User);
				}else {
					System.out.println("No account");
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, account User) {
		if (amount <= User.balance) {
			if(amount <= cash) {
			User.balance = User.balance - amount;
			cash = cash - amount;
			System.out.println("Ok, here is your money, enjoy!");
			}else {
				System.out.println("ATM has not enough cash");
			}
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}
 
	};

	public static void main(String[] args) {
		ATM atm = new ATM();
		account[] accounts = {
		 new account(100,112),
		 new account(1100,161)
		};
		atm.run(accounts);
	};

}
