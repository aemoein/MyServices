package main.Service;
import java.util.Scanner;
public class VodafoneMobileRecharge implements Vodafone{
	Scanner input =new Scanner(System.in);
	
	@Override
	public void VodafoneForm() {
		
		System.out.println("Hi you are in Etisalat Mobile Recharge");
		System.out.println("Please enter your Phone Numper");
		int PhoneNumber = input.nextInt();
		System.out.println("Please enter the amount you need to recharge");
		int MobileRechargeAmount = input.nextInt();
		System.out.println("yor phone number is: " + PhoneNumber 
				+ "the requird Amount you should pay is" + MobileRechargeAmount);
		
	}
	

}
