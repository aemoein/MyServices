package com.MyServices.Main.Data;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Transaction.ITransaction;
import com.MyServices.Main.Transaction.PaymentTransaction;
import com.MyServices.Main.User.CurrentUser;

@RestController
public class TransactionDataControl 
{
	Data data = Data.getInstance();
	
	@GetMapping("/Data/Display/Transactions")
	public void DisplayAllTransactions()
	{
		System.out.println();
		if ( data.getTransactions().isEmpty())
		{
			System.out.println("NO TRANSACTIONS AVALIABLE");
		}
		
		else
		{
			System.out.println("userId"+"\t"+"TransactionID"+"\t"+"Service"+"\t\t\t\t"+"$"+"amount"+"\t\t"+"type");
			Iterator<ITransaction> itr = data.getTransactions().iterator();
			ITransaction transaction;
			while(itr.hasNext())
			{   transaction = itr.next();
				transaction.printTransaction();
			}
		}
		System.out.println();
	}
	
	@GetMapping("/Data/Display/PaymentTransactions")
	public void DisplayPaymentTransactions()
	{
		System.out.println();
		if ( data.getPayTransactions().isEmpty())
		{
			System.out.println("NO TRANSACTIONS AVALIABLE");
		}
		
		else
		{
			System.out.println("userId"+"\t"+"TransactionID"+"\t"+"Service"+"\t\t\t"+"$"+"amount"+"\t"+"type");
			Iterator<ITransaction> itr = data.getPayTransactions().iterator();
			ITransaction transaction;
			while(itr.hasNext())
			{   transaction = itr.next();
				transaction.printTransaction();
			}
		}
		System.out.println();
	}
	
	@PostMapping("/Data/Add/Transaction")
	public void SaveTranscation(@RequestBody ITransaction transaction)
	{
		data.getTransactions().add(transaction);
	}
	
	@GetMapping("/Data/Display/UserTransactions")
	public void getUserTransactions()
	{
		if ( data.getTransactions().isEmpty())
		{
			System.out.println("NO TRANSACTIONS AVALIABLE");
		}
		
		else
		{
			System.out.println();
			System.out.println("userId"+"\t"+"TransactionID"+"\t"+"Service"+"\t\t\t\t"+"Amount"+"\t"+"Type");
			Iterator<ITransaction> itr = data.getTransactions().iterator();
			ITransaction transaction;
			while(itr.hasNext())
			{   transaction = itr.next();
				if(transaction.getUID() == CurrentUser.currentUser.getUserID())
				{
					transaction.printTransaction();
				}
			}
		}
	}
	
	@PostMapping("/Data/Add/PaymentTransaction")
	public void newPaymentTransaction(@RequestBody String service, @RequestBody int amount)
	{
		ITransaction transaction = new PaymentTransaction(CurrentUser.currentUser.getUserID(), service, amount);
		SaveTranscation(transaction);
		data.getPayTransactions().add(transaction);
	}
	
	@GetMapping("/Data/Display/UserPayTransactions")
	public void getUserPayTransactions()
	{
		if ( data.getPayTransactions().isEmpty())
		{
			System.out.println("NO TRANSACTIONS AVALIABLE");
		}
		
		else
		{
			System.out.println("userId"+"\t"+"TransactionID"+"\t"+"Service"+"\t\t\t\t"+"Amount"+"\t"+"Type");
			Iterator<ITransaction> itr = data.getPayTransactions().iterator();
			ITransaction transaction;
			while(itr.hasNext())
			{   transaction = itr.next();
				if(transaction.getUID() == CurrentUser.currentUser.getUserID())
				{
					transaction.printTransaction();
				}
			}
		}
	}
}
