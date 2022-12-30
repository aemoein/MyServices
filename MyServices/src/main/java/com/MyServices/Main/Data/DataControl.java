package com.MyServices.Main.Data;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Payment.Wallet;
import com.MyServices.Main.Transaction.ITransaction;
import com.MyServices.Main.Transaction.PaymentTransaction;
import com.MyServices.Main.Transaction.Refund;
import com.MyServices.Main.User.CurrentUser;
import com.MyServices.Main.User.User;
import com.MyServices.Main.User.UserCounter;

@RestController
public class DataControl 
{
	Data data = Data.getInstance();
	
	@GetMapping("/Data/Display/Users")
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
	
	@GetMapping("/Data/Display/DiscountedService")
	public void DisplayDiscountedServices()
	{
		System.out.println();
		if ( data.getDiscountedServices().isEmpty())
		{
			System.out.println("NO SERVICES ON DISCOUNT");
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
	
	@GetMapping("/Data/Display/DiscountedUsers")
	public void DisplayDiscountedUsers()
	{
		System.out.println();
		if ( data.getDiscountedUsers().isEmpty())
		{
			System.out.println("NO USERS WITH DISCOUNT");
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
	
	@GetMapping("/Data/Display/RefundRequests")
	public void DisplayAllRefundRequests()
	{
		System.out.println();
		if ( data.getRefundRequest().isEmpty())
		{
			System.out.println("NO REQUESTS AVALIABLE");
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
	
	@GetMapping("/Data/Check/OverallDisount/{id}")
	public boolean OverallDiscountCheck(@PathVariable("id") int id)
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
	
	@GetMapping("/Data/Check/ServiceDisount/{Service}")
	public boolean ServiceDiscountCheck(@PathVariable("Service") String ServiceName)
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
	
	@GetMapping("/Data/Wallet/{id}")
	public Wallet getCurrentWallet(@PathVariable("id") int UID)
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
	
	@PostMapping("/Data/Add/ServiceDiscount/{Service}")
	public void AddServiceDiscount(@PathVariable("Service") String ServiceName)
	{
		data.getDiscountedServices().add(ServiceName);
	}
	
	@PostMapping("/Data/Add/UserDisount/{id}")
	public void AddUserDiscount(@PathVariable("id") String id)
	{
		data.getDiscountedUsers().add(id);
	}
	
	@GetMapping("/Data/Check/User/SignUp")
	public boolean checkUserSignUP(@RequestBody User User) 
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
	
	@PostMapping("/Data/Add/Wallet")
	public void createwallet(@RequestBody int UID)
	{
		Wallet wallet = new Wallet(UID, 0);
		data.getWallets().add(wallet);
	}
	
	@PostMapping("/Data/Add/User")
	public void RegisterUser(@RequestBody User User) 
	{
		if(checkUserSignUP(User)) 
		{
			data.getUsers().add(User);
			createwallet(User.getUserID());
		}
	}
	
	@GetMapping("/Data/Check/User/Login/{username}")
	public boolean checkUserLoggedIN(@RequestBody String UserName,String Password) 
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
	
	
	@PostMapping("/Data/Display/PendingRefundRquest")
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
	
	@PostMapping("/Data/Add/Transaction")
	public void SaveTranscation(@RequestBody ITransaction transaction)
	{
		data.getTransactions().add(transaction);
	}
	
	@GetMapping("/Data/Display/PendingRefund/{id}")
	public ITransaction getTransaction(@PathVariable("id") int id)
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
	
	@GetMapping("/Data/Display/UserRefund")
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
	
	@PostMapping("/Data/Add/Refund")
	public void RequestRefund(@RequestBody ITransaction refundTransaction)
	{
		Refund refund = new Refund(refundTransaction);
		data.getRefundRequest().add(refund);
	}
}
