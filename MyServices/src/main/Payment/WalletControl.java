package main.Payment;

import java.util.Iterator;
import main.Data.Data;
import main.Transaction.TransactionControl;
import main.User.User;
import main.User.UserControl;

public class WalletControl {

	private Data data = Data.getInstance();
	UserControl userControl = new UserControl();
	TransactionControl transactionControl = new TransactionControl();
	
	public Wallet getwallet()
	{
		Iterator<Wallet> itr = data.getWallets().iterator();
		while(itr.hasNext())
		{
			Wallet tempWallet = itr.next();
			if(tempWallet.getUID() == userControl.getCurrentUser().getUserID())
			{
				return tempWallet;
			}
		}
		return null;
	}
	
	public void addfunds(int amount)
	{
		Wallet currWallet = getwallet();
		int newAmount = currWallet.getAmount() + amount;
		currWallet.setAmount(newAmount);
		transactionControl.newWalletTransaction(amount);
		System.out.println("New Balance: $"+getwallet().getAmount());
	}
	
	public void getWalletBalance()
	{
		Wallet currWallet = getwallet();
		System.out.println(currWallet.getAmount());
	}
	
	public void WalletPay(int amountPaid)
	{
		int currAmount =  getwallet().getAmount();
		if (amountPaid > currAmount)
		{
			System.out.println("Insufficient Funds Choose another Method");
		}
		else 
		{
			currAmount = currAmount - amountPaid;
			getwallet().setAmount(currAmount);
			System.out.println("Ammount Successfully paid");
			System.out.print("New Balance is: ");
			System.out.println(getwallet().getAmount());
		}
	}
}
