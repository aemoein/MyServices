package main.Transaction;

import main.Data.Data;

public class RefundControl {
	
	public void RequestRefund(Transaction refundTransaction)
	{
		Refund refund = new Refund(refundTransaction);
		Data data = Data.getInstance();
		data.getRefundRequest().add(refund);
	}
}
