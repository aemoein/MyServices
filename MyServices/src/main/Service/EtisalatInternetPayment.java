package main.Service;
import java.util.Scanner;
public class EtisalatInternetPayment implements Etisalat  
{
	Scanner input =new Scanner(System.in);

	@Override
	public void EtisalatForm() {
		System.out.println("Hi you are in Etisalat Internet Payment");
		System.out.println("Please enter your Phone Numper");
		int PhoneNumber = input.nextInt();
		int InternetAmount = 300;
		System.out.println("yor phone number is: " + PhoneNumber 
				+ "the requird Amount you should pay is" + InternetAmount);
		
	}
	

}
