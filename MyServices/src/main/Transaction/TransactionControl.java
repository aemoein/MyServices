package main.Transaction;

import java.util.Iterator;

import main.Data.Data;

public class TransactionControl {
	Data data = Data.getInstance();
	
	public void printTransactions(ITransaction transaction) 
	{
		transaction.printTransaction();
	}
	
	
	public void SaveTranscation(ITransaction transaction)
	{
		data.getTransactions().add(transaction);
	}
	
	
	public PaymentTransaction getTransaction(int id)
	{
		Iterator<PaymentTransaction> itr = data.getPayTransactions().iterator();
		while(itr.hasNext())
		{
			if(itr.next().TransactionID == id)
			{
				return itr.next();
			}
		}
		return null;
	}
	
	
	public void getTransactions(int id)
	{
		Iterator<PaymentTransaction> itr = data.getPayTransactions().iterator();
		while(itr.hasNext())
		{
			if(itr.next().userId == id)
			{
				itr.next().printTransaction(); 
			}
		}
	}
	
}
