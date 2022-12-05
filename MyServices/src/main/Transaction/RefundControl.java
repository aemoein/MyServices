package main.Transaction;

import java.util.Iterator;

import main.Data.Data;

public class RefundControl extends TransactionControl
{
	Data data = Data.getInstance();
	
	public void RequestRefund(ITransaction refundTransaction)
	{
		Refund refund = new Refund(refundTransaction);
		data.getRefundRequest().add(refund);
	}
	
	public void getRefundRequests()
	{
		Iterator<Refund> itr = data.getRefundRequest().iterator();
		Refund refund;
		while(itr.hasNext())
		{
			refund = itr.next();
			if(refund.getUID() == getCurrentUID())
			{
				refund.printRefund();
			}
		}
	}
	
	public void processRefundRequest()
	{
		
	}
}
