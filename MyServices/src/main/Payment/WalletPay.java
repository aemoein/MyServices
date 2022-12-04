package main.Payment;

public class WalletPay extends WalletControl implements PaymentMethod
{	
	@Override
	public void pay(int amountPaid) 
	{
		WalletPay(amountPaid);
	}
}
