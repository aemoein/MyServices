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
	
	
	public ITransaction getTransaction(int id)
	{
		Iterator<ITransaction> itr = data.getPayTransactions().iterator();
		ITransaction transaction;
		while(itr.hasNext())
		{	transaction = itr.next();
			if(transaction.getTID() == id)
			{
				return transaction;
			}
		}
		return null;
	}
	
	
	public void getTransactions()
	{
		if ( data.getTransactions().isEmpty())
		{
			System.out.println("NO TRANSACTIONS AVALIABLE");
		}
		
		else
		{
			System.out.println("userId"+"\t"+"TransactionID"+"\t"+"Service"+"\t\t\t\t"+"$"+"amount"+"\t\t"+"type");
			Iterator<ITransaction> itr = data.getTransactions().iterator();
			ITransaction transaction;
			while(itr.hasNext())
			{   transaction = itr.next();
				if(transaction.getUID() == getCurrentUID())
				{
					transaction.printTransaction();
				}
			}
		}
	}
	
	public void newPaymentTransaction(String service, int amount)
	{
		ITransaction transaction = new PaymentTransaction(getCurrentUID(), service, amount);
		SaveTranscation(transaction);
		data.getPayTransactions().add(transaction);
	}
	
	public void newWalletTransaction(int amount)
	{
		String service = "Wallet";
		ITransaction transaction = new WalletTransaction(getCurrentUID(), service, amount);
		SaveTranscation(transaction);
	}
	
	public void newRefundTransaction(int amount)
	{
		String service = "Refund";
		ITransaction transaction = new RefundTransaction(getCurrentUID(), service, amount);
		SaveTranscation(transaction);
	}
	
	public void getPayTransactions()
	{
		if ( data.getPayTransactions().isEmpty())
		{
			System.out.println("NO TRANSACTIONS AVALIABLE");
		}
		
		else
		{
			System.out.println("userId"+"\t"+"TransactionID"+"\t"+"Service"+"\t\t\t"+"$"+"amount"+"\t"+"type");
			Iterator<ITransaction> itr = data.getPayTransactions().iterator();
			ITransaction transaction;
			while(itr.hasNext())
			{   transaction = itr.next();
				if(transaction.getUID() == getCurrentUID())
				{
					transaction.printTransaction();
				}
			}
		}
	}
	
	
}
