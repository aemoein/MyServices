package com.MyServices.Main.Payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Data.DataControl;
import com.MyServices.Main.Transaction.TransactionControl;
import com.MyServices.Main.User.UserControl;

@RestController
public class WalletControl {
	DataControl dataControl = new DataControl();
	UserControl userControl = new UserControl();
	TransactionControl transactionControl = new TransactionControl();
	
	@GetMapping("/Wallet/Get/{id}")
	public Wallet getwallet(@PathVariable("id") int UID)
	{
		return dataControl.getCurrentWallet(UID);
	}
	
	@PostMapping("/Wallet/AddFuds/{id}/{amount}")
	public String addfunds(@PathVariable("id") int UID, @PathVariable("amount") int amount)
	{
		int newAmount = getwallet(UID).getAmount() + amount;
		getwallet(UID).setAmount(newAmount);
		transactionControl.newWalletTransaction(amount);
		return ("New Balance: $" + getwallet(UID).getAmount());
	}
	
	@PostMapping("/Wallet/Refund/{id}/{amount}")
	public void refundAmount(@PathVariable("id") int UID, @PathVariable("amount") int amount)
	{
		int newAmount = getwallet(UID).getAmount() + amount;
		getwallet(UID).setAmount(newAmount);
	}
	
	@GetMapping("/Wallet/Balance/{id}")
	public int getWalletBalance(@PathVariable("id") int UID)
	{
		Wallet currWallet = getwallet(UID);
		return currWallet.getAmount();
	}
	
	@PostMapping("/Wallet/Pay/{id}/{amount}")
	public boolean WalletPay(@PathVariable("id") int UID, @PathVariable("amount") int amountPaid)
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
