package main.Data;

import java.util.Scanner;

public class DataInterface extends DataControl
{
	Scanner scanner = new Scanner(System.in);
	public void DataForm()
	{
		int choice;
		System.out.println("Choose an option");
		System.out.println("1- View All Users");
		System.out.println("2- View All Transactions");
		System.out.println("3- View Payment Transactions");
		System.out.println("4- View Discounted Service");
		System.out.println("5- View Users With Discount");
		System.out.println("6- View All Refund Requests");
		System.out.print("Choice: ");
		choice = scanner.nextInt();
		DisplayData(choice);
	}
}
