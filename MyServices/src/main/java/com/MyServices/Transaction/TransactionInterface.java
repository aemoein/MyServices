package com.MyServices.Transaction;

import com.MyServices.Data.Data;

public class TransactionInterface extends TransactionControl{
	Data data = Data.getInstance();
	
	public void getUserTransactions()
	{
		getTransactions();
		System.out.println();
	}
	
}
