package com.MyServices.Main.Transaction;

public class PaymentTransaction extends Transaction implements ITransaction
{
	public PaymentTransaction(int userid, String Service, int amount) {
		this.Service = Service;
		this.amount = amount;
		TransactionCounter.TCounter++;
		TransactionID = TransactionCounter.TCounter;
		this.userId = userid;
		type = "Payment Transaction";
	}
	
	@Override
	public void printTransaction() 
	{
		System.out.println(userId+"\t"+TransactionID+"\t\t"+Service+" "+"\t"+"$"+amount+"\t"+type);
	}

	@Override
	public int getUID() {
		return userId;
	}

	@Override
	public int getTID() {
		return TransactionID;
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
}
