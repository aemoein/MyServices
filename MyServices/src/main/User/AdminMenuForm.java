package main.User;

import java.util.Iterator;
import java.util.Scanner;

import main.SystemEntry;
import main.Data.Data;
import main.Data.DataInterface;
import main.Transaction.RefundInterface;

public class AdminMenuForm extends AdminControl
{
	private Data data = Data.getInstance();;
	Scanner scanner = new Scanner(System.in);
	SystemEntry systemEntry = new SystemEntry();
	RefundInterface refundInterface = new RefundInterface();
	DataInterface dataInterface = new DataInterface();
	
	public void AdminMenu() 
	{
		int choice,c2;
		boolean flag = true;
		System.out.println("ADMIN MENU");
		
		do {
		System.out.println("Choose From The Options Below");
		System.out.println("1- Process Refund Requests");
		System.out.println("2- Add Service Discounts");
		System.out.println("3- Add Overall Discounts");
		System.out.println("4- Display Data");
		System.out.println("5- EXIT");
		System.out.print("Choice: ");
		choice = scanner.nextInt();
		
		switch (choice) 
		{
			case 1: 
			{
				refundInterface.processRefundForm();
				break;
			}
			case 2: 
			{
				DisplayAllAvaliableServices();
				c2 = scanner.nextInt();
				data.getDiscountedServices().add(SelectService(c2));
				break;
			}
			case 3: 
			{
				DisplayAllUsers();
				System.out.println("Select User: ");
				c2 = scanner.nextInt();
				data.getDiscountedUsers().add(Integer.toString(c2));
				break;
			}
			case 4: 
			{
				dataInterface.DataForm();
				break;
			}
			case 5: 
			{
				systemEntry.SystemStart();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		}while(flag);
	}
	
	public void DisplayAllAvaliableServices() 
	{
		System.out.println("1- Etisalat Mobile Recharge");
		System.out.println("2- Orange Mobile Recharge");
		System.out.println("3- Vodafone Mobile Recharge");
		System.out.println("4- We Mobile Recharge");
		System.out.println("5- Etisalat Internet Payment");
		System.out.println("6- Orange Internet Payment");
		System.out.println("7- Vodafone Internet Payment");
		System.out.println("8- We Internet Payment");
		System.out.println("9- Monthly Landline Payment");
		System.out.println("10- Quarterly Landline Payment");
		System.out.print("Choice: ");
	}
	
	public void DisplayAllUsers()
	{
		while(!data.getUsers().isEmpty()) 
		{
			Iterator<User> itr = data.getUsers().iterator();
			while (itr.hasNext()) 
			{
				itr.next().display();
			}
		}
	}
}
