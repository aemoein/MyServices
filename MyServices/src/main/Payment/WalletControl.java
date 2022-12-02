package main.Payment;

import java.util.Iterator;
import main.Data.Data;

public class WalletControl {

	private Data data = Data.getInstance();
	
	public Wallet getwallet(int id)
	{
		Iterator<Wallet> itr = data.getWallets().iterator();
		while(itr.hasNext())
		{
			if(itr.next().getUserid() == id)
			{
				return itr.next();
			}
		}
		return null;
	}
	
	public void addfunds(int id, int amount)
	{
		Wallet currWallet = getwallet(id);
		int newAmount = currWallet.getAmount();
		currWallet.setAmount(newAmount);
	}
	
	public void getWalletBalance(int id)
	{
		Wallet currWallet = getwallet(id);
		System.out.println(currWallet.getAmount());
	}
}
