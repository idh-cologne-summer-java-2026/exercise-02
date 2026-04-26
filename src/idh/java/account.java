package idh.java;


public class account {
	
	private int accountNumber;
	private int accountBalance = 100;
	boolean abbuchen(int amount) {
		if (accountBalance - amount < 0) {
			System.out.print("You're broke!");
			return false;
		}
		else {accountBalance = accountBalance - amount;
			return true;
		}
	}
	
	int getAccountNr() {
		return accountNumber;
	}
	
	void setAccountNr(int i) {
		accountNumber = i;
	}
	
//	account(ATM x){
//		accountNumber = Arrays.asList(x.accounts).indexOf(this);
//	}
}