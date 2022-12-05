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
		while(itr.hasNext())
		{
			if(itr.next().getUID() == getCurrentUID())
			{
				itr.next().printRefund();
			}
		}
	}
}
