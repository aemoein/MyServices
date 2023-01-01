package com.MyServices.Main;

import java.util.Scanner;

import com.MyServices.Main.Data.DataControl;
import com.MyServices.Main.Payment.PaymentInterface;
import com.MyServices.Main.Payment.WalletInterface;
import com.MyServices.Main.Service.ServiceInterface;
import com.MyServices.Main.Transaction.RefundInterface;
import com.MyServices.Main.Transaction.TransactionControl;
import com.MyServices.Main.Transaction.TransactionInterface;
import com.MyServices.Main.User.CurrentUser;
import com.MyServices.Main.User.UserControl;

public class MenuInterface {

	PaymentInterface paymentInterface = new PaymentInterface();
	ServiceInterface serviceInterface = new ServiceInterface();
	RefundInterface refundInterface = new RefundInterface();
	TransactionControl transactionControl = new TransactionControl();
	TransactionInterface transactionInterface = new TransactionInterface();
	CurrentUser currentUser = new CurrentUser();
	WalletInterface walletInterface = new WalletInterface();
	UserControl userControl = new UserControl();
	SystemEntry systemEntry = new SystemEntry();
	DataControl dataControl = new DataControl();
	
	Scanner scanner = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);
	boolean menuflag = true;
	

	public void menuForm() 
	{
		System.out.println("WELECOME TO MyServices");
		
		
	do {
		System.out.println();
		System.out.println("MAIN MENU");
		System.out.println("HOW CAN WE HELP YOU TODAY?");
		System.out.println("1- Services");
		System.out.println("2- Refunds");
		System.out.println("3- Service Search");
		System.out.println("4- Display Discounted Services");
		System.out.println("5- Transactions");
		System.out.println("6- View Account");
		System.out.println("7- Wallet Options");
		System.out.println("8- EXIT");
		
		switch (Input.inputInt(scanner)) 
		{
			case 1: 
			{
				paymentInterface.DisplayPaymentForm(serviceInterface.DisplayServiceForm());
				System.out.println();
				break;
			}
			
			case 2: 
			{
				refundInterface.refundForm();
				break;
			}
			
			case 3: 
			{
				String lineString;
				System.out.println();
				System.out.println("Search For Service");
				System.out.print("Enter Search: ");
				lineString = scanner2.nextLine();
				dataControl.ServiceSearch(lineString);
				break;
			}
			
			case 4: 
			{
				dataControl.DisplayDiscountedServices();
				break;
			}
			
			case 5: 
			{
				transactionInterface.getUserTransactions();
				break;
			}
			
			case 6: 
			{
				System.out.println();
				currentUser.printCurrentUser();
				System.out.println();
				break;
			}
			
			case 7: 
			{
				walletInterface.walletForm();
				break;
			}
			
			case 8: 
			{
				menuflag = false;
				systemEntry.SystemStart();
				break;
			}
			
			default:
				System.out.println("PLEASE ENTER A VALID OPTION");
				break;
		}
	} while (menuflag == true);
	}
	
}
