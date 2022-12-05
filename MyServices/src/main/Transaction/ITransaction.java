package main.Transaction;

public interface ITransaction 
{
	public void printTransaction();
	public int getUID();
	public int getTID();
	public int getAmount();
}
