package main.Payment;

public class PaymentInterface extends PaymentControl{
	
	
	void DisplayPaymentForm()
	{
		String Service = " ";
		int UID = 0;
		int amount = 0;
		System.out.println("PAYMENT FORM");
		getBill(Service, UID, amount);
	}
}
