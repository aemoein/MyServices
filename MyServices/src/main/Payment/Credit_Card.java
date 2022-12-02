package main.Payment;

public class Credit_Card implements PaymentMethod{

	@Override
	public void pay(int amountPaid) {
		System.out.println("$"+amountPaid+" have been paid using a credit card");
	}

}
