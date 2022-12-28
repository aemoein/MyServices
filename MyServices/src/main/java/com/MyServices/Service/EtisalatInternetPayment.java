package com.MyServices.Service;

import java.util.Scanner;

public class EtisalatInternetPayment implements Etisalat  
{
	Scanner input = new Scanner(System.in);
	
	private String ServiceName = "Etisalat Internet Payment";
	private static int Amount = 300;

	@Override
	public void EtisalatForm() 
	{
		System.out.println(ServiceName);
		System.out.print("Phone Number: ");
		int PhoneNumber = input.nextInt();
		
		System.out.println("Phone Number: " + PhoneNumber );
	}

	@Override
	public String returnServiceName() {
		return ServiceName;
	}

	@Override
	public int returnAmount() {
		return Amount;
	}
}
