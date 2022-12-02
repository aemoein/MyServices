package main.Service;

import java.util.Scanner;

public class Hospitals implements Donations {

	Scanner scanner = new Scanner(System.in);
	@Override
	public void DonationForm() {
		
		System.out.println("Hi you are in NGOs donation form");
		System.out.println("Please enetr the amount you want to donate: ");
		int amount = scanner.nextInt();
		System.out.println("you have now donated with: " + amount);
	}
}
