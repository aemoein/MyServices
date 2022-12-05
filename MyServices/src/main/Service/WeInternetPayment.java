package main.Service;
import java.util.Scanner;
public class WeInternetPayment implements We{
	Scanner input =new Scanner(System.in);
	@Override
	public void WeForm() {
		
		System.out.println("Hi you are in Etisalat Internet Payment");
		System.out.println("Please enter your Phone Numper");
		
		int PhoneNumber = input.nextInt();
		int InternetAmount = 300;
		
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
