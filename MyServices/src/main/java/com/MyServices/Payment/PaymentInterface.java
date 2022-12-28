package com.MyServices.Payment;

import java.util.Scanner;

import com.MyServices.Main.Input;
import com.MyServices.Main.MenuInterface;
import com.MyServices.Main.SystemEntry;

public class PaymentInterface extends PaymentControl
{
	Scanner scanner = new Scanner(System.in);
	SystemEntry systemEntry = new SystemEntry();
	
	public void DisplayPaymentForm(Payment payment)
	{
		MenuInterface menuInterface = new MenuInterface();
		
		System.out.println();
		System.out.println("PAYMENT FORM");
		System.out.println();
		
		getBill(payment);
		
		System.out.println();
		System.out.print("SERVICE NAME: ");
		System.out.println(payment.getServiceName());
		
		System.out.print("AMOUNT: $");
		System.out.println(payment.getAmount());
		
		
		
		do 
		{
			System.out.println();
			System.out.println("1- PROCEED TO PAYMENT");
			System.out.println("2- CANCEL AND RETURN TO MAIN MENU");
			switch (Input.inputInt(scanner)) 
			{
				case 1: 
				{
					boolean flag = true;
					do 
					{
						System.out.println();
						System.out.println("Select Payment Method");
						System.out.println("1- Cash");
						System.out.println("2- Credit Card");
						System.out.println("3- Wallet");
						
						switch (Input.inputInt(scanner)) 
						{
							case 1: 
							{
								CashPayment(payment);
								flag = false;
								break;
							}
							case 2: 
							{
								CreditCardPayment(payment);
								flag = false;
								break;
							}
							case 3: 
							{
								if (WalletPayment(payment))
								{
									flag = false;
								}
								break;
							}
							default:
								System.out.println("PLEASE ENTER A VALID OPTION");
								break;
						}
					}while(flag);
					
					createTransaction(payment);
					
					System.out.println();
					System.out.println("1- RETURN TO MAIN MENU");
					System.out.println("2- EXIT THE APP");
					
					if (Input.inputInt(scanner) == 1)
					{
						menuInterface.menuForm();
					}
					
					if (Input.inputInt(scanner) == 2)
					{
						systemEntry.SystemStart();
					}
					break;
				}
				
				case 2: 
				{
					menuInterface.menuForm();
					break;
				}
			
				default:
					System.out.println("PLEASE ENTER A VALID OPTION");
					break;
			}
			
		} while (true);
		
	}
}
