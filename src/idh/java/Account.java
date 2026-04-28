package idh.java;

public class Account {
  int balance; 
  
  int accNum; 
  
  public Account(int accNum, int status) {
	  this.accNum = accNum; 
	  this.balance = status; 
  }
  public int getAccNum() {
	  return accNum; 
  }
  public void setAccNum(int accNum) {
	  this.accNum = accNum; 
  }
  public int getBalance() {
	  return balance; 
  }
  public void setBalance(int status) {
	  this.balance = status; 
  }
  public void withdraw(int sum) {
	  this.balance = balance -sum; 
  }
}
