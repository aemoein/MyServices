package main.Payment;

import java.util.Scanner;
import main.Input;
import main.User.CurrentUser;

public class WalletInterface extends WalletControl
{
	Scanner scanner = new Scanner(System.in);
	public void displayAddForm()
	{
		System.out.print("Current Balance: $");
		getWalletBalance(CurrentUser.currentUser.getUserID());
		
		System.out.print("Add Funds: ");
		int AddedFunds = scanner.nextInt();
		
		addfunds(CurrentUser.currentUser.getUserID() ,AddedFunds);
		
		System.out.print("Funds Added Successfully");
	}
	
	public void displayCurrentBalance()
	{
		System.out.print("Current Wallet Balance: $");
		getWalletBalance(CurrentUser.currentUser.getUserID());
	}
	
	public void walletForm()
	{
		boolean flag = true;
		do 
		{
			System.out.println();
			System.out.println("WALLET MENU");
			System.out.println("Choose From The Options Below");
			System.out.println("1- Add Funds");
			System.out.println("2- View Avaliable Funds");
			switch (Input.inputInt(scanner)) 
			{
				case 1: 
				{
					System.out.println();
					displayAddForm();
					flag = false;
					break;
				}
				
				case 2: 
				{
					System.out.println();
					displayCurrentBalance();
					flag = false;
					break;
				}
				default:
					System.out.println();
					System.out.println("PLEASE ENTER A VALID OPTION");
					break;
			}
			System.out.println();
		}while(flag);
	}
}
