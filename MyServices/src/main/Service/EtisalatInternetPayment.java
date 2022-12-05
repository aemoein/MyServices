package main.Service;
import java.util.Scanner;
public class EtisalatInternetPayment implements Etisalat  
{
	Scanner input = new Scanner(System.in);

	@Override
	public void EtisalatForm() 
	{
		System.out.println("Etisalat Internet Payment");
		System.out.println("Please enter your Phone Number: ");
		
		int PhoneNumber = input.nextInt();
		int InternetAmount = 300;
		
		
		
		System.out.println("your phone number is: " + PhoneNumber 
				+"the required Amount you should pay is" + InternetAmount);
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
