package main.Payment;

public class WalletPay extends WalletControl implements PaymentMethod
{	
	@Override
	public boolean pay(int amountPaid) 
	{
		return WalletPay(amountPaid);
	}
}
