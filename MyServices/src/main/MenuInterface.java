package main;

import main.Payment.PaymentInterface;
import main.Service.ServiceInterface;

public class MenuInterface {

	PaymentInterface paymentInterface = new PaymentInterface();
	ServiceInterface serviceInterface = new ServiceInterface();
	public void menuForm() 
	{
		System.out.println("WELECOME TO MyServices");
		System.out.println();
		System.out.println("MAIN MENU");
		System.out.println("HOW CAN WE HELP YOU TODAY?");
		System.out.println("1- Services");
		System.out.println("2- Refunds");
		System.out.println("3- Transactions");
		System.out.println("4- View Account");
		System.out.println("5- Add Funds To Wallet");
		
		paymentInterface.DisplayPaymentForm(serviceInterface.DisplayServiceForm());
	}
}
