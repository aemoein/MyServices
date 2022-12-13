package main;

import java.util.Scanner;

import main.Payment.PaymentInterface;
import main.Payment.WalletInterface;
import main.Service.ServiceInterface;
import main.Transaction.RefundInterface;
import main.Transaction.TransactionControl;
import main.Transaction.TransactionInterface;
import main.User.CurrentUser;
import main.User.UserControl;

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
	Scanner scanner = new Scanner(System.in);
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
		System.out.println("3- Transactions");
		System.out.println("4- View Account");
		System.out.println("5- Wallet Options");
		System.out.println("6- EXIT");
		
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
				transactionInterface.getUserTransactions();
				break;
			}
			
			case 4: 
			{
				System.out.println();
				currentUser.printCurrentUser();
				System.out.println();
				break;
			}
			
			case 5: 
			{
				walletInterface.walletForm();
				break;
			}
			case 6: 
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
