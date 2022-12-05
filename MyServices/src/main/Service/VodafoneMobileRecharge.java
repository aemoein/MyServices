package main.Service;
import java.util.Scanner;
public class VodafoneMobileRecharge implements Vodafone{
	Scanner input =new Scanner(System.in);
	
	@Override
	public void VodafoneForm() {
		
		System.out.println("Etisalat Mobile Recharge");
		System.out.println("Please enter your Phone Number");
		int PhoneNumber = input.nextInt();
		
		System.out.println("Please enter the amount you need to recharge");
		int MobileRechargeAmount = input.nextInt();
		
		System.out.println("Phone Number: " + PhoneNumber);
		System.out.println("Amount to be Paid: " + MobileRechargeAmount);
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
