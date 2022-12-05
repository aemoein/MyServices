package main.Service;

import java.util.Scanner;

public class MonthlyLL implements Landline
{
	Scanner scanner = new Scanner(System.in);
	private String ServiceName = "Monthly Landline Payment";
	private int Amount = 100;

	@Override
	public void LandLineForm() {
		System.out.println(ServiceName);
		System.out.print("Phone Number: ");
		int PhoneNumber = scanner.nextInt();
		
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
