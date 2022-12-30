package com.MyServices.Main.Transaction;

import com.MyServices.Main.Data.Data;

public class TransactionInterface extends TransactionControl{
	Data data = Data.getInstance();
	
	public void getUserTransactions()
	{
		getTransactions();
		System.out.println();
	}
	
}
