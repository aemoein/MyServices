package main.Service;

import java.util.Scanner;

public class NGOs implements Donations {
	Scanner scanner = new Scanner(System.in);
	private String ServiceName = "NGOs Donation\t";
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
