package main.Service;

import java.util.Scanner;

public class QuarterlyLL implements Landline{
	Scanner scanner = new Scanner(System.in);

	@Override
	public void LandLineForm() {
		System.out.println("Hi you are in quarter monthly payment land line form");
		System.out.println("please enter the phone number: ");
		int PhoneNumber = scanner.nextInt();
		int amount = 100*4;
		System.out.println("your phone number is: " + PhoneNumber
				+ "the amount you paid: " + amount);
		
	}

}
