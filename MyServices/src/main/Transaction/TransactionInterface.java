package main.Transaction;

import main.Data.Data;

public class TransactionInterface {
	TransactionControl tControl = null;
	Data data = Data.getInstance();
	
	
	public TransactionInterface() {
		tControl = new TransactionControl();
	}
	
	public void getUserTransactions()
	{
		int id = 0;
		tControl.getTransactions(id);
		System.out.println();
	}
	
}
