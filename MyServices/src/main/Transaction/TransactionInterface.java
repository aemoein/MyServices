package main.Transaction;

import main.Data.Data;

public class TransactionInterface extends TransactionControl{
	Data data = Data.getInstance();
	
	public void getUserTransactions()
	{
		int id = 0;
		getTransactions(id);
		System.out.println();
	}
	
}
