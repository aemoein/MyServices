package main.Payment;

import java.util.Scanner;

import main.MenuInterface;

public class PaymentInterface extends PaymentControl{
	
	
	void DisplayPaymentForm()
	{
		MenuInterface menuInterface = new MenuInterface();
		String Service = " ";
		int UID = 0, amount = 0, paymentProcess, billAmount;
		System.out.println("PAYMENT FORM");
		billAmount = getBill(Service, UID, amount);
		
		System.out.println("1- PROCEED TO PAYMENT");
		System.out.println("2- CANCEL AND RETURN TO MAIN MENU");
		
		Scanner scanner = new Scanner(System.in);
		paymentProcess = scanner.nextInt();
		
		if (paymentProcess == 1)
		{
			int choice;
			System.out.println("Select Payment Method");
			System.out.println("1- Cash");
			System.out.println("2- Credit Card");
			System.out.println("3- Wallet");
			choice = scanner.nextInt();
			
			payBill(billAmount, choice);
			createTransaction(UID, Service, billAmount);
			
			int choiceB;
			System.out.println("1- RETURN TO MAIN MENU");
			System.out.println("2- EXIT THE APP");
			choiceB = scanner.nextInt();
			
			if (choiceB == 1)
			{
				//add a code over here to return to Sign up/Login
			}
			
			if (choiceB == 2)
			{
				menuInterface.menuForm();
			}
		}
		
		if(paymentProcess == 2)
		{
			menuInterface.menuForm();
		}
	}
}
