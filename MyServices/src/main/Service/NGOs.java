package main.Service;

import java.util.Scanner;

public class NGOs implements Donations {
	Scanner scanner = new Scanner(System.in);

	@Override
	public void DonationForm() {
		
		System.out.println("Hi you are in NGOs donation form");
		System.out.println("Please enter the amount you want to donate: ");
		int amount = scanner.nextInt();
		
		System.out.println("you have now donated with: " + amount);
		
	}

	@Override
	public void returnServiceName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnAmount() {
		// TODO Auto-generated method stub
		
	}

}
