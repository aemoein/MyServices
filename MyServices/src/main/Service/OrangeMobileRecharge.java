package main.Service;
import java.util.Scanner;
public class OrangeMobileRecharge implements Orange{

	Scanner input =new Scanner(System.in);

	@Override
	public void OrangeForm() {
		System.out.println("Hi you are in Orange Mobile Recharge");
		System.out.println("Please enter your Phone Numper");
		int PhoneNumber = input.nextInt();
		System.out.println("Please enter the amount you need to recharge");
		int MobileRechargeAmount = input.nextInt();
		System.out.println("yor phone number is: " + PhoneNumber 
				+ "the requird Amount you should pay is" + MobileRechargeAmount);
		
	}

}
