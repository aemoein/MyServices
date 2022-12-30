package com.MyServices.Main.Service;

import java.util.Scanner;

public class Hospitals implements Donations {

	Scanner scanner = new Scanner(System.in);
	private String ServiceName = "Hospital Donation\t";
	private int Amount;
	
	@Override
	public void DonationForm() {
		
		System.out.println(ServiceName);
		System.out.println("Please enter the amount you would like to donate: ");
		Amount = scanner.nextInt();
		
		System.out.println("Thanks For Your Donation");
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
