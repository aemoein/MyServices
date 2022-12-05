package main.Service;
import java.util.Scanner;
public class VodafoneMobileRecharge implements Vodafone
{
	Scanner input = new Scanner(System.in);
	private String ServiceName = "Vodafone Mobile Recharge";
	private static int Amount;
	
	@Override
	public void VodafoneForm() {
		
		System.out.println(ServiceName);
		System.out.print("Phone Number: ");
		int PhoneNumber = input.nextInt();
		
		System.out.print("Recharge Amount: ");
		Amount = input.nextInt();
		
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
