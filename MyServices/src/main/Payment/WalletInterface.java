package main.Payment;

import java.util.Scanner;

public class WalletInterface extends WalletControl
{
	Scanner scanner = new Scanner(System.in);
	public void displayAddForm()
	{
		System.out.print("Current Balance: $");
		getWalletBalance();
		
		System.out.print("Add Funds: ");
		int AddedFunds = scanner.nextInt();
		
		addfunds(AddedFunds);
		
		System.out.print("Funds Added Successfully");
	}
	
	public void displayCurrentBalance()
	{
		System.out.print("Current Wallet Balance: $");
		getWalletBalance();
	}
}
