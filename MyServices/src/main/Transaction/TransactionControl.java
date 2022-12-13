package main.Transaction;

import main.Data.DataControl;
import main.User.CurrentUser;
import main.User.UserControl;

public class TransactionControl {
	UserControl userControl = new UserControl();
	DataControl dataControl = new DataControl();
	
	public int getCurrentUID()
	{
		return CurrentUser.currentUser.getUserID();
	}
	
	public void printTransactions(ITransaction transaction) 
	{
		transaction.printTransaction();
	}
	
	
	public void SaveTranscation(ITransaction transaction)
	{
		dataControl.SaveTranscation(transaction);
	}
	
	
	public ITransaction getTransaction(int id)
	{
		return dataControl.getTransaction(id);
	}
	
	
	public void getTransactions()
	{
		dataControl.getUserTransactions();
	}
	
	public void newPaymentTransaction(String service, int amount)
	{
		dataControl.newPaymentTransaction(service, amount);
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
		dataControl.getUserPayTransactions();
	}
	
	
}
