package main.Transaction;

import main.Data.Data;

public class TransactionInterface extends TransactionControl{
	Data data = Data.getInstance();
	
	public void getUserTransactions()
	{
		getTransactions();
		System.out.println();
	}
	
}
