package com.MyServices.Data;

import java.util.Iterator;
import com.MyServices.Payment.Wallet;
import com.MyServices.Transaction.ITransaction;
import com.MyServices.Transaction.PaymentTransaction;
import com.MyServices.Transaction.Refund;
import com.MyServices.User.CurrentUser;
import com.MyServices.User.User;
import com.MyServices.User.UserCounter;

public class DataControl 
{
	Data data = Data.getInstance();
	
	public void DisplayAllUsers()
	{
		Iterator<User> itr = data.getUsers().iterator();
		while (itr.hasNext()) 
		{
			System.out.println();
			itr.next().display();
			System.out.println();
		}
	}
	
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
	
	public void DisplayDiscountedServices()
	{
		System.out.println();
		if ( data.getDiscountedServices().isEmpty())
		{
			System.out.println("NO TRANSACTIONS AVALIABLE");
		}
		else 
		{
			String ServiceN;
			Iterator<String> itr = data.getDiscountedServices().iterator();
			while(itr.hasNext())
			{
				ServiceN = itr.next();
				System.out.println(ServiceN);
			}
		}
		System.out.println();
	}
	
	public void DisplayDiscountedUsers()
	{
		System.out.println();
		if ( data.getDiscountedUsers().isEmpty())
		{
			System.out.println("NO TRANSACTIONS AVALIABLE");
		}
		else 
		{
			Iterator<String> itr = data.getDiscountedUsers().iterator();
			while(itr.hasNext())
			{
				int UID = Integer.parseInt(itr.next());
				System.out.println(UID);
			}
		}
		System.out.println();
	}
	
	public void DisplayAllRefundRequests()
	{
		System.out.println();
		if ( data.getRefundRequest().isEmpty())
		{
			System.out.println("NO TRANSACTIONS AVALIABLE");
		}
		else 
		{
			Iterator<Refund> itr = data.getRefundRequest().iterator();
			Refund refund;
			while(itr.hasNext())
			{
				refund = itr.next();
				refund.printRefund();
			}
		}
		System.out.println();
	}
	
	public boolean OverallDiscountCheck(int id)
	{
		Iterator<String> itr = data.getDiscountedUsers().iterator();
		while(itr.hasNext())
		{
			int UID = Integer.parseInt(itr.next());
			if(id == UID)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean ServiceDiscountCheck(String ServiceName)
	{
		String ServiceN;
		Iterator<String> itr = data.getDiscountedServices().iterator();
		while(itr.hasNext())
		{
			ServiceN = itr.next();
			if(ServiceN == ServiceName)
			{
				return true;
			}
		}
		return false;
	}
	
	public Wallet getCurrentWallet(int UID)
	{
		Iterator<Wallet> itr = data.getWallets().iterator();
		while(itr.hasNext())
		{
			Wallet tempWallet = itr.next();
			if(tempWallet.getUID() == UID)
			{
				return tempWallet;
			}
		}
		return null;
	}
	
	public void AddServiceDiscount(String ServiceName)
	{
		data.getDiscountedServices().add(ServiceName);
	}
	
	public void AddUserDiscount(String id)
	{
		data.getDiscountedUsers().add(id);
	}
	
	public boolean checkUserSignUP(User User) 
	{
		if(UserCounter.UserCounter == 1)
		{
			return true;
		}
		
		else 
		{
			Iterator<User> i = data.getUsers().iterator();
			while (i.hasNext()) 
			{
				User tempUser = i.next();
				if(tempUser.getEmail() == User.getEmail()) {
					System.out.println("Sorry this email is already taken :("+"\n");
					return false;
				}
				
				if(tempUser.getUserName() == User.getUserName()) {
					System.out.println("Sorry this username is already taken :("+"\n");
					return false;	
				}
			}
		}
		return true;
	}
	
	public void createwallet(int UID)
	{
		Wallet wallet = new Wallet(UID, 0);
		data.getWallets().add(wallet);
	}
	
	public void RegisterUser(User User) 
	{
		if(checkUserSignUP(User)) 
		{
			data.getUsers().add(User);
			createwallet(User.getUserID());
		}
	}
	
	public boolean checkUserLoggedIN(String UserName,String Password) 
	{
		User tempUser;
			Iterator<User> i = data.getUsers().iterator();
			while (i.hasNext()) 
			{
				tempUser = i.next();
				String CurrentUserName = tempUser.getUserName();
				String CurrPassword = tempUser.getpassword();
				String CurrEmail = tempUser.getEmail();
				
				if(CurrentUserName.equals(UserName) || CurrEmail.equals(UserName))
				{
					if (Password.equals(CurrPassword))
					{
						CurrentUser.currentUser = tempUser; 
						return true;
					}
				}	
			}
		System.out.println("The Username/Email or password is incorrect..");
		return false;
	}
	
	public Refund getPendingRefund()
	{
		Iterator<Refund> itr = data.getRefundRequest().iterator();
		Refund refund;
		while(itr.hasNext())
		{
			refund = itr.next();
			if(refund.getRefundStatus().equals("Pending Review"))
			{
				return refund;
			}
		}
		System.out.println();
		System.out.println("No More Refund Requests Avaliable");
		return null;
	}
	
	public void SaveTranscation(ITransaction transaction)
	{
		data.getTransactions().add(transaction);
	}
	
	public ITransaction getTransaction(int id)
	{
		Iterator<ITransaction> itr = data.getPayTransactions().iterator();
		ITransaction transaction;
		while(itr.hasNext())
		{	transaction = itr.next();
			if(transaction.getTID() == id)
			{
				return transaction;
			}
		}
		return null;
	}
	
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
	
	public void newPaymentTransaction(String service, int amount)
	{
		ITransaction transaction = new PaymentTransaction(CurrentUser.currentUser.getUserID(), service, amount);
		SaveTranscation(transaction);
		data.getPayTransactions().add(transaction);
	}
	
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
	
	public void getUserRefundRequests()
	{
		Iterator<Refund> itr = data.getRefundRequest().iterator();
		Refund refund;
		while(itr.hasNext())
		{
			refund = itr.next();
			if(refund.getUID() == CurrentUser.currentUser.getUserID())
			{
				refund.printRefund();
			}
		}
	}
	
	public void RequestRefund(ITransaction refundTransaction)
	{
		Refund refund = new Refund(refundTransaction);
		data.getRefundRequest().add(refund);
	}
}
