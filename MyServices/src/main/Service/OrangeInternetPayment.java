package main.Service;
import java.util.Scanner;
public class OrangeInternetPayment implements Orange{
	Scanner input =new Scanner(System.in);

	@Override
	public void OrangeForm() {
		System.out.println("Hi you are in Orange Internet Payment");
		System.out.println("Please enter your Phone Number");
		
		int PhoneNumber = input.nextInt();
		int InternetAmount = 350;
		
		System.out.println("yor phone number is: " + PhoneNumber 
				+ "the requird Amount you should pay is" + InternetAmount);
		
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
