package com.MyServices.Service;

import java.util.Scanner;
public class OrangeInternetPayment implements Orange{
	Scanner input =new Scanner(System.in);
	private String ServiceName = "Orange Internet Payment\t";
	private int Amount = 350;

	@Override
	public void OrangeForm() {
		System.out.println(ServiceName);
		System.out.print("Phone Number: ");
		int PhoneNumber = input.nextInt();
		
		System.out.println("Phone Number: " + PhoneNumber);
		
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
