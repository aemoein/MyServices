package main.Payment;

public class Cash implements PaymentMethod{

	@Override
	public void pay(int amountPaid) {
		System.out.println("$"+amountPaid+" have been paid using cash");
	}
}
