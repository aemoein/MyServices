package com.MyServices.Main.Payment;

import com.MyServices.Main.Data.DataControl;
import com.MyServices.Main.Transaction.TransactionControl;
import com.MyServices.Main.User.UserControl;

public class WalletControl {
	DataControl dataControl = new DataControl();
	UserControl userControl = new UserControl();
	TransactionControl transactionControl = new TransactionControl();
	
	public Wallet getwallet(int UID)
	{
		return dataControl.getCurrentWallet(UID);
	}
	
	public void addfunds(int UID,int amount)
	{
		int newAmount = getwallet(UID).getAmount() + amount;
		getwallet(UID).setAmount(newAmount);
		transactionControl.newWalletTransaction(amount);
		System.out.println("New Balance: $"+getwallet(UID).getAmount());
	}
	
	public void refundAmount(int UID, int amount)
	{
		int newAmount = getwallet(UID).getAmount() + amount;
		getwallet(UID).setAmount(newAmount);
	}
	
	public void getWalletBalance(int UID)
	{
		Wallet currWallet = getwallet(UID);
		System.out.println(currWallet.getAmount());
	}
	
	public boolean WalletPay(int UID,int amountPaid)
	{
		int currAmount =  getwallet(UID).getAmount();
		if (amountPaid > currAmount)
		{
			System.out.println("Insufficient Funds Choose another Method");
			return false;
		}
		else 
		{
			currAmount = currAmount - amountPaid;
			getwallet(UID).setAmount(currAmount);
			System.out.println("Ammount Successfully paid");
			System.out.print("New Balance is: ");
			System.out.println(getwallet(UID).getAmount());
			return true;
		}
	}
}
