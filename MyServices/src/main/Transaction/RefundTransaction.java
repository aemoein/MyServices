package main.Transaction;

public class RefundTransaction extends Transaction implements ITransaction
{
	public RefundTransaction(int userid, String Service, int amount) 
	{
		this.Service = Service;
		this.amount = amount;
		TransactionCounter.TCounter++;
		TransactionID = TransactionCounter.TCounter;
		this.userId = userid;
		type = "Refund Transaction";
	}

	@Override
	public void printTransaction() 
	{
		System.out.println(userId+"/t"+TransactionID+"/t"+Service+"/t"+amount+"/t"+type);
	}
}
