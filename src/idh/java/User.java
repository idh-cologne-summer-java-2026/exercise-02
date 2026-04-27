package idh.java;

public class User {
	
	private String name;
	private int id;
	private double balance;
	
	public User(String name, int id, double balance) {
		 this.name = name;
		 this.id = id;
		 this.balance = balance;
	}
	//	Getters
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	//	Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
