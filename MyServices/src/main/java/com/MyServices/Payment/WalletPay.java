package com.MyServices.Payment;

import com.MyServices.User.CurrentUser;

public class WalletPay extends WalletControl implements PaymentMethod
{	
	@Override
	public boolean pay(int amountPaid) 
	{
		return WalletPay(CurrentUser.currentUser.getUserID(),amountPaid);
	}
}
