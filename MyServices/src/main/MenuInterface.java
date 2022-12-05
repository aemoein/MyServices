package main;

import java.util.Scanner;

import main.Payment.PaymentInterface;
import main.Payment.WalletInterface;
import main.Service.ServiceInterface;
import main.Transaction.RefundInterface;
import main.Transaction.TransactionControl;
import main.Transaction.TransactionInterface;
import main.User.UserControl;

public class MenuInterface {

	PaymentInterface paymentInterface = new PaymentInterface();
	ServiceInterface serviceInterface = new ServiceInterface();
	RefundInterface refundInterface = new RefundInterface();
	TransactionControl transactionControl = new TransactionControl();
	TransactionInterface transactionInterface = new TransactionInterface();
	WalletInterface walletInterface = new WalletInterface();
	UserControl userControl = new UserControl();
	Scanner scanner = new Scanner(System.in);
	int choice, choice2;
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
		System.out.print("Enter Choice: ");
		choice = scanner.nextInt();
		System.out.println();
		
		switch (choice) {
			case 1: 
			{
				paymentInterface.DisplayPaymentForm(serviceInterface.DisplayServiceForm());
				System.out.println();
				break;
			}
			
			case 2: 
			{
				System.out.println("REFUND MENU");
				System.out.println("Choose From The Options Below");
				System.out.println("1- Request A Refund");
				System.out.println("2- Check A Refund Request");
				System.out.print("Choice: ");
				choice2 = scanner.nextInt();
				
				switch (choice2) 
				{
					case 1: 
					{
						refundInterface.RequestForm();
						break;
					}
					
					case 2: 
					{
						refundInterface.DisplayRefundRequests();
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + choice2);
				}
				System.out.println();
				break;
			}
			
			case 3: 
			{
				transactionInterface.getUserTransactions();
				//transactionControl.getTransactions();
				break;
			}
			
			case 4: 
			{
				userControl.printCurrentUser();
				System.out.println();
				break;
			}
			
			case 5: 
			{
				System.out.println("WALLET MENU");
				System.out.println("Choose From The Options Below");
				System.out.println("1- Add Funds");
				System.out.println("2- View Avaliable Funds");
				System.out.print("Choice: ");
				choice2 = scanner.nextInt();
				
				switch (choice2) 
				{
					case 1: 
					{
						walletInterface.displayAddForm();
						break;
					}
					
					case 2: 
					{
						walletInterface.displayCurrentBalance();
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + choice2);
				}
				System.out.println();
				break;
			}
			case 6: 
			{
				menuflag = false;
				System.exit(0);
				break;
			}
			
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	} while (menuflag == true);
}
	
}
