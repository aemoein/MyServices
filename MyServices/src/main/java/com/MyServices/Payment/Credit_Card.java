package com.MyServices.Payment;

public class Credit_Card implements PaymentMethod{

	@Override
	public boolean pay(int amountPaid) {
		System.out.println("$"+amountPaid+" have been paid using a credit card");
		
		return true;
	}

}
