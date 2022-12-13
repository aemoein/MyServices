package main.Transaction;

public class RefundControl extends TransactionControl
{
	public void RequestRefund(ITransaction refundTransaction)
	{
		dataControl.RequestRefund(refundTransaction);
	}
	
	public void getRefundRequests()
	{
		dataControl.getUserRefundRequests();
	}
}
