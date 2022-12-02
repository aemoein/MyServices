package main.Transaction;

public abstract class Transaction {
	
	TransactionCounter counter = new TransactionCounter();
	protected int userId;
	protected int TransactionID;
	protected String Service;
	protected int amount;
	protected String type;
}
