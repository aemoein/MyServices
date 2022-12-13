package main.Payment;

import main.Data.DataControl;
import main.Transaction.TransactionControl;
import main.User.UserControl;

public class WalletControl {
	DataControl dataControl = new DataControl();
	UserControl userControl = new UserControl();
	TransactionControl transactionControl = new TransactionControl();
	
	public Wallet getwallet()
	{
		return dataControl.getCurrentWallet();
	}
	
	public void addfunds(int amount)
	{
		int newAmount = getwallet().getAmount() + amount;
		getwallet().setAmount(newAmount);
		transactionControl.newWalletTransaction(amount);
		System.out.println("New Balance: $"+getwallet().getAmount());
	}
	
	public void getWalletBalance()
	{
		Wallet currWallet = getwallet();
		System.out.println(currWallet.getAmount());
	}
	
	public boolean WalletPay(int amountPaid)
	{
		int currAmount =  getwallet().getAmount();
		if (amountPaid > currAmount)
		{
			System.out.println("Insufficient Funds Choose another Method");
			return false;
		}
		else 
		{
			currAmount = currAmount - amountPaid;
			getwallet().setAmount(currAmount);
			System.out.println("Ammount Successfully paid");
			System.out.print("New Balance is: ");
			System.out.println(getwallet().getAmount());
			return true;
		}
	}
}
