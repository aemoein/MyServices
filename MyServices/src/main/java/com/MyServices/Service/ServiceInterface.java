package com.MyServices.Service;

import java.util.Scanner;

import com.MyServices.Main.Input;
import com.MyServices.Payment.Payment;

public class ServiceInterface extends ServiceControl
{
	private Scanner scanner = new Scanner(System.in);
	
	public Payment DisplayServiceForm() 
	{
		getCurrentUID();
		
		do 
		{
			System.out.println();
			System.out.println("CHOOSE THE DESIRED SERVICE");
			System.out.println("1- Mobile Recharge");
			System.out.println("2- Internet Payment");
			System.out.println("3- Landline");
			System.out.println("4- Donations");
			
			switch (Input.inputInt(scanner)) {
				case 1: 
				{
					System.out.println();
					System.out.println("MOBILE RECHARGE MENU");
					System.out.println("CHOOSE THE DESIRED SERVICE PROVIDER");
					System.out.println("1- Etisalat");
					System.out.println("2- Orange");
					System.out.println("3- Vodafone");
					System.out.println("4- We");
					return MobileRechargeSPMenu(Input.inputInt(scanner));
				}
				
				case 2: 
				{
					System.out.println();
					System.out.println("INTERNET PAYMENT MENU");
					System.out.println("CHOOSE THE DESIRED SERVICE PROVIDER");
					System.out.println("1- Etisalat");
					System.out.println("2- Orange");
					System.out.println("3- Vodafone");
					System.out.println("4- We");
					return InternetPaymentSPMenu(Input.inputInt(scanner));
				}
				
				case 3: 
				{
					System.out.println();
					System.out.println("LANDLINE MENU");
					System.out.println("CHOOSE THE DESIRED PAYMENT PLAN");
					System.out.println("1- Monthly");
					System.out.println("2- Quarterly");
					return LandlineSPMenu(Input.inputInt(scanner));
				}
				
				case 4: 
				{
					System.out.println();
					System.out.println("DONATIONS MENU");
					System.out.println("EVERY PENNY YOU DONATE MATTERS!");
					System.out.println("CHOOSE THE DESIRED CHARITY SERVICE TO DONATE TO");
					System.out.println("1- Schools");
					System.out.println("2- Hospitals");
					System.out.println("3- NGOs");
					return DonationsSPMenu(Input.inputInt(scanner));
				}
				
			default:
				System.out.println("PLEASE ENTER A VALID OPTION");
				break;
			}
		
		}while(true);
	}
}
