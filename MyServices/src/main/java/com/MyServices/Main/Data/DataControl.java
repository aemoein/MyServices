package com.MyServices.Main.Data;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Payment.Wallet;
import com.MyServices.Main.Transaction.ITransaction;
import com.MyServices.Main.Transaction.Refund;
import com.MyServices.Main.User.CurrentUser;

@RestController
public class DataControl 
{
	Data data = Data.getInstance();
	UserDataControl userDataControl = new UserDataControl();
	
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
			System.out.println("User ID" + "\t\t" + "Full Name" + "\t\t" + "Email" + "\t\t\t" + "User Name" + "\t\t" + "Phone Number" + "\t\t" + "Gender" + "\t\t" + "Status");
			Iterator<String> itr = data.getDiscountedUsers().iterator();
			while(itr.hasNext())
			{
				int UID = Integer.parseInt(itr.next());
				userDataControl.getUser(UID).Print();
				System.out.println(userDataControl.getUser(UID).Print());
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
	
	@PostMapping ("/Data/Display/PendingRefundRequest")
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
	
	@GetMapping("/Data/Service/Search/{Service}")
	public void ServiceSearch(@PathVariable("Service") String ServiceName)
	{
		String ServiceN;
		Iterator<String> itr = data.getAvaliableServices().iterator();
		while(itr.hasNext())
		{
			ServiceN = itr.next();
			if(ServiceN.contains(ServiceName))
			{
				
				System.out.println(ServiceN);
			}
		}
		System.out.println();
	}
	
	@GetMapping("/Data/Service/Display")
	public void DisplayAllServices()
	{
		Iterator<String> itr = data.getAvaliableServices().iterator();
		while(itr.hasNext())
		{	
			System.out.println(itr.next());
		}
		System.out.println();
	}
}
