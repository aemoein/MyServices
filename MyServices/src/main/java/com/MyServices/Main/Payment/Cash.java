package com.MyServices.Main.Payment;

public class Cash implements PaymentMethod{

	@Override
	public boolean pay(int amountPaid) {
		System.out.println("$"+amountPaid+" have been paid using cash");
		
		return true;
	}
}
