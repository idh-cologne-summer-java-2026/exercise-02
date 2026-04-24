package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM 
{
	//Start amount of cash after filling
	private int iAmountOfCash = 50;
	
	// Array of account number and account balance
	private int[][] aAccounts = 
	{
		    {123, 100},
		    {234, 200},
		    {345, 300},
		    {456, 400},		    
		    {567, 500},		    
		    {678, 600}   
	};
	// Row of array of entered account number
	private int iAccountsRow;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() 
	{
		BufferedReader m_br = new BufferedReader(new InputStreamReader(System.in));
		while (true) 
		{
			try 
			{
				System.out.print("Enter your account number: ");	
				int iAccount = Integer.parseInt(m_br.readLine());
				
				boolean bAccountFound = false;
				int i=0;
				while(!bAccountFound || i<aAccounts.length)
				{
					if(iAccount == aAccounts[i][0])
					{
						bAccountFound = true;
						iAccountsRow = i;
					}
					i++;
				}
				
				if(!bAccountFound)
				{
					System.out.println("We don't know this account number!");
					break;
				}
			} 
			catch (Exception e) 
			{
				System.out.println("We don't know this account number!");
				break;
			}
		
			try 
			{
				System.out.print("Enter the amount to withdraw: ");
				int iAmount = Integer.parseInt(m_br.readLine());
				cashout(iAmount);
			} 
			catch (Exception e) 
			{
				System.out.println("We don't deal in coins!");
				break;
			}
		}
	}

	public void cashout(int iAmount) 
	{
		
		if (iAmountOfCash < iAmount) 
		{
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		} 
		else if (iAmount <= aAccounts[iAccountsRow][1]) 
		{
			aAccounts[iAccountsRow][1] = aAccounts[iAccountsRow][1] - iAmount;
			iAmountOfCash = iAmountOfCash - iAmount;
			System.out.println("Ok, here is your money, enjoy!");
		} 
		else 
		{
			System.out.println("Sorry, not enough money in the bank.");
			// Perhaps we can offer a loan			
			System.out.println("If you would like to apply for a loan, please contact a bank assistant.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}