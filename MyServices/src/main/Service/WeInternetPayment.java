package main.Service;
import java.util.Scanner;
public class WeInternetPayment implements We
{
	Scanner input = new Scanner(System.in);
	private String ServiceName = "We Internet Payment\t";
	private int Amount = 300;
	
	@Override
	public void WeForm() {
		
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
