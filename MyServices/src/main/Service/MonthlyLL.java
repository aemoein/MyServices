package main.Service;

import java.util.Scanner;

public class MonthlyLL implements Landline{
	Scanner scanner = new Scanner(System.in);

	@Override
	public void LandLineForm() {
		System.out.println("Hi you are in monthly payment land line form");
		System.out.println("please enter the phone number: ");
		
		int PhoneNumber = scanner.nextInt();
		int amount = 100;
		
		System.out.println("your phone number is: " + PhoneNumber
				+ "the amount you paid: " + amount);
		
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
