package main.Service;

import java.util.Scanner;

public class QuarterlyLL implements Landline
{
	Scanner scanner = new Scanner(System.in);
	private String ServiceName = "Quarterly Landline Payment";
	private int Amount = 400;

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
