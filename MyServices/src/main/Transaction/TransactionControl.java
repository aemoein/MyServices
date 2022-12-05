package main.Transaction;

import java.util.Iterator;

import main.Data.Data;
import main.User.UserControl;

public class TransactionControl {
	Data data = Data.getInstance();
	UserControl userControl = new UserControl();
	
	public int getCurrentUID()
	{
		return userControl.getCurrentUser().getUserID();
	}
	
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
	
	
	public void getTransactions()
	{
		Iterator<PaymentTransaction> itr = data.getPayTransactions().iterator();
		while(itr.hasNext())
		{
			if(itr.next().userId == getCurrentUID())
			{
				itr.next().printTransaction(); 
			}
		}
	}
	
	public void newPaymentTransaction(String service, int amount)
	{
		ITransaction transaction = new PaymentTransaction(getCurrentUID(), service, amount);
		SaveTranscation(transaction);
	}
	
}
