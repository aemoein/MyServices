package main.Service;
import java.util.Scanner;
public class Schools implements Donations{
	
	Scanner scanner = new Scanner(System.in);
	private String ServiceName = "School Donation";
	private int Amount;
	
	@Override
	public void DonationForm() {
		
		System.out.println(ServiceName);
		System.out.print("Please enter the amount you would like to donate: ");
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
