package main.Payment;

import java.util.Iterator;
import main.Data.Data;
import main.User.UserControl;

public class WalletControl {

	private Data data = Data.getInstance();
	UserControl userControl = new UserControl();
	
	public Wallet getwallet()
	{
		Iterator<Wallet> itr = data.getWallets().iterator();
		while(itr.hasNext())
		{
			if(itr.next().getUserid() == userControl.getCurrentUser().getUserID())
			{
				return itr.next();
			}
		}
		return null;
	}
	
	public void addfunds(int amount)
	{
		Wallet currWallet = getwallet();
		int newAmount = currWallet.getAmount();
		currWallet.setAmount(newAmount);
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
			getwallet().getAmount();
		}
	}
}
