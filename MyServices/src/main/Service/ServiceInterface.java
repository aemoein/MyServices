package main.Service;

import java.util.Scanner;

import main.Payment.Payment;

public class ServiceInterface extends ServiceControl
{
	private int choice, choiceSP;
	private Scanner scanner = new Scanner(System.in);
	
	public Payment DisplayServiceForm() 
	{
		getCurrentUID();
		System.out.println("CHOOSE THE DESIRED SERVICE");
		System.out.println("1- Mobile Recharge");
		System.out.println("2- Internet Payment");
		System.out.println("3- Landline");
		System.out.println("4- Donations");
		System.out.print("CHOICE (1-4): ");
		choice = scanner.nextInt();
		System.out.println();
		
		switch (choice) {
			case 1: 
			{
				System.out.println("MOBILE RECHARGE MENU");
				System.out.println("CHOOSE THE DESIRED SERVICE PROVIDER");
				System.out.println("1- Etisalat");
				System.out.println("2- Orange");
				System.out.println("3- Vodafone");
				System.out.println("4- We");
				System.out.print("CHOICE (1-4): ");
				choiceSP = scanner.nextInt();
				System.out.println();
				
				return MobileRechargeSPMenu(choiceSP);
			}
			
			case 2: 
			{
				System.out.println("INTERNET PAYMENT MENU");
				System.out.println("CHOOSE THE DESIRED SERVICE PROVIDER");
				System.out.println("1- Etisalat");
				System.out.println("2- Orange");
				System.out.println("3- Vodafone");
				System.out.println("4- We");
				System.out.print("CHOICE (1-4): ");
				choiceSP = scanner.nextInt();
				System.out.println();
				
				return InternetPaymentSPMenu(choiceSP);
			}
			
			case 3: 
			{
				System.out.println("LANDLINE MENU");
				System.out.println("CHOOSE THE DESIRED PAYMENT PLAN");
				System.out.println("1- Monthly");
				System.out.println("2- Quarterly");
				System.out.print("CHOICE (1-2): ");
				choiceSP = scanner.nextInt();
				System.out.println();
				
				return LandlineSPMenu(choiceSP);
			}
			
			case 4: 
			{
				System.out.println("DONATIONS MENU");
				System.out.println("EVERY PENNY YOU DONATE MATTERS!");
				System.out.println("CHOOSE THE DESIRED CHARITY SERVICE TO DONATE TO");
				System.out.println("1- Schools");
				System.out.println("2- Hospitals");
				System.out.println("3- NGOs");
				System.out.print("CHOICE (1-3): ");
				choiceSP = scanner.nextInt();
				System.out.println();
				
				return DonationsSPMenu(choiceSP);
			}
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
	}
}
