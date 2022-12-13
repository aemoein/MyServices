package main.Data;

import java.util.Scanner;

import main.Input;

public class DataInterface extends DataControl
{
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
					DisplayAllUsers();
					break;
				}
				
				case 2: 
				{
					DisplayAllTransactions();
					break;
				}
				
				case 3: 
				{
					DisplayPaymentTransactions();
					break;
				}
				
				case 4: 
				{
					DisplayDiscountedServices();
					break;
				}
				
				case 5: 
				{
					DisplayDiscountedUsers();
					break;
				}
				
				case 6: 
				{
					DisplayAllRefundRequests();
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
