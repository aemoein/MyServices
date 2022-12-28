package com.MyServices.Service;
import java.util.Scanner;

public class VodafoneInternetPayment implements Vodafone {
	
	Scanner input = new Scanner(System.in);
	private String ServiceName = "Vodafone Internet Payment";
	private int Amount = 300;
	
	@Override
	public void VodafoneForm() {

		System.out.println(ServiceName);
		System.out.print("Phone Number: ");
		int PhoneNumber = input.nextInt();
		
		System.out.println("Phone Number : " + PhoneNumber );
		
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
