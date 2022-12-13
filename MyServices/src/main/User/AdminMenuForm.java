package main.User;

import java.util.Scanner;
import main.Input;
import main.SystemEntry;
import main.Data.DataInterface;
import main.Transaction.RefundInterface;

public class AdminMenuForm extends AdminControl
{
	Scanner scanner = new Scanner(System.in);
	SystemEntry systemEntry = new SystemEntry();
	RefundInterface refundInterface = new RefundInterface();
	DataInterface dataInterface = new DataInterface();
	
	public void AdminMenu() 
	{
		boolean flag = true;
		
		
		do {
			System.out.println();
			System.out.println("--- ADMIN MENU ---");
		System.out.println("Choose From The Options Below");
		System.out.println("1- Process Refund Requests");
		System.out.println("2- Add Service Discounts");
		System.out.println("3- Add Overall Discounts");
		System.out.println("4- Display Data");
		System.out.println("5- EXIT");
		switch (Input.inputInt(scanner)) 
		{
			case 1: 
			{
				refundInterface.processRefundForm();
				break;
			}
			case 2: 
			{
				DisplayAllAvaliableServices();
				AddServiceDiscount(Input.inputInt(scanner));
				break;
			}
			case 3: 
			{
				DisplayAllUsers();
				AddUserDiscount(Integer.toString(Input.inputInt(scanner)));
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
				System.out.println("PLEASE ENTER A VALID OPTION");
				break;
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
	}
}
