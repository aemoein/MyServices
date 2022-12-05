package main.Service;

import main.Payment.Payment;
import main.Payment.PaymentControl;

public class ServiceControl extends PaymentControl
{
	public Payment ServicePay(int UID, String ServiceName, int amount)
	{
		return startPayment(UID, ServiceName, amount);
	}
	
	
}
