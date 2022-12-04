package main.Payment;

import java.util.Scanner;

public class WalletInterface extends WalletControl{

	public void displayAddForm()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Current Balance: ");
		getWalletBalance(0);
		
		System.out.print("Add Funds: ");
		int AddedFunds = scanner.nextInt();
		
		addfunds(0, AddedFunds);
		
		System.out.print("Funds Added Successfully");
	}
	
	public void displayCurrentBalance()
	{
		System.out.print("Current Balance: ");
		getWalletBalance(0);
	}
}
