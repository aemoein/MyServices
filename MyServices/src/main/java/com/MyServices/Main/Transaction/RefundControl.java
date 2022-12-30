package com.MyServices.Main.Transaction;

import com.MyServices.Main.Payment.WalletControl;

public class RefundControl extends TransactionControl
{
	WalletControl walletControl = new WalletControl();
	TransactionControl transactionControl = new TransactionControl();
	
	public void RequestRefund(ITransaction refundTransaction)
	{
		dataControl.RequestRefund(refundTransaction);
	}
	
	public void getRefundRequests()
	{
		dataControl.getUserRefundRequests();
	}
	
	public void createRefundTransaction(Refund refund)
	{
		walletControl.refundAmount(refund.getUID() ,refund.getRefundTransaction().getAmount());
		transactionControl.newRefundTransaction(refund.getUID() ,refund.getRefundTransaction().getAmount());	
	}
}
