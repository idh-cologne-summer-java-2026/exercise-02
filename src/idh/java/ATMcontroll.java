package idh.java;

public class ATMcontroll{
	
	private int balance;
	private int PIN;
	
	public ATMcontroll(int balance, int PIN) {
		this.balance = balance;
		this.PIN = PIN;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getPIN() {
		return this.PIN;
	}
}
	

