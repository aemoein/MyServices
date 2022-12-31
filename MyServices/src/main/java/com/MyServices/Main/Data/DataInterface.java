package com.MyServices.Main.Data;

import java.util.Scanner;

import com.MyServices.Main.Input;

public class DataInterface
{
	private DataControl dataControl = new DataControl();
	TransactionDataControl tDataControl = new TransactionDataControl();
	UserDataControl uDataControl = new UserDataControl();
	boolean flag = true;
	Scanner scanner = new Scanner(System.in);
	public void DataForm()
	{
		do 
		{
			System.out.println("--- Data Display Menu ---");
			System.out.println("Choose an option");
			System.out.println("1- View All Users");
			System.out.println("2- View All Transactions");
			System.out.println("3- View Payment Transactions");
			System.out.println("4- View Discounted Service");
			System.out.println("5- View Users With Discount");
			System.out.println("6- View All Refund Requests");
			System.out.println("7- Exit");
			
			switch (Input.inputInt(scanner)) 
			{
				case 1: 
				{
					uDataControl.DisplayAllUsers();
					break;
				}
				
				case 2: 
				{
					tDataControl.DisplayAllTransactions();
					break;
				}
				
				case 3: 
				{
					tDataControl.DisplayPaymentTransactions();
					break;
				}
				
				case 4: 
				{
					dataControl.DisplayDiscountedServices();
					break;
				}
				
				case 5: 
				{
					dataControl.DisplayDiscountedUsers();
					break;
				}
				
				case 6: 
				{
					dataControl.DisplayAllRefundRequests();
					break;
				}
				
				case 7:
				{
					flag = false;
					break;
				}
				
				default:
					System.out.println("PLEASE ENTER A VALID OPTION");
					break;
			}
			
		}while(flag);
	}
}
