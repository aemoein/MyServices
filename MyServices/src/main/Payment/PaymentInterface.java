package main.Payment;

import java.util.Scanner;

import main.MenuInterface;

public class PaymentInterface extends PaymentControl
{
	Scanner scanner = new Scanner(System.in);
	
	public void DisplayPaymentForm(Payment payment)
	{
		MenuInterface menuInterface = new MenuInterface();
		
		int paymentProcess;
		System.out.println("PAYMENT FORM");
		
		getBill(payment);
		System.out.print("SERVICE NAME: ");
		System.out.println(payment.getServiceName());
		
		System.out.print("AMOUNT: $");
		System.out.println(payment.getAmount());
		
		System.out.println("1- PROCEED TO PAYMENT");
		System.out.println("2- CANCEL AND RETURN TO MAIN MENU");
		paymentProcess = scanner.nextInt();
		
		if (paymentProcess == 1)
		{
			int choice;
			System.out.println("Select Payment Method");
			System.out.println("1- Cash");
			System.out.println("2- Credit Card");
			System.out.println("3- Wallet");
			choice = scanner.nextInt();
			
			payBill(payment, choice);
			createTransaction(payment);
			
			int choiceB;
			System.out.println("1- RETURN TO MAIN MENU");
			System.out.println("2- EXIT THE APP");
			choiceB = scanner.nextInt();
			
			if (choiceB == 1)
			{
				menuInterface.menuForm();
			}
			
			if (choiceB == 2)
			{
				//add a code over here to return to Sign up/Login
			}
		}
		
		if(paymentProcess == 2)
		{
			menuInterface.menuForm();
		}
	}
}
