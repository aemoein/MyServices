package com.MyServices.Main.Transaction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Data.DataControl;
import com.MyServices.Main.Data.TransactionDataControl;
import com.MyServices.Main.User.CurrentUser;
import com.MyServices.Main.User.UserControl;

@RestController
public class TransactionControl {
	UserControl userControl = new UserControl();
	DataControl dataControl = new DataControl();
	TransactionDataControl tDataControl = new TransactionDataControl();
	
	@GetMapping("/Transaction/GetUID")
	public int getCurrentUID()
	{
		return CurrentUser.currentUser.getUserID();
	}
	
	@GetMapping("/Transaction/Print")
	public void printTransactions(@RequestBody ITransaction transaction) 
	{
		transaction.printTransaction();
	}
	
	@PostMapping("/Transaction/Save")
	public void SaveTranscation(@RequestBody ITransaction transaction)
	{
		tDataControl.SaveTranscation(transaction);
	}
	
	@GetMapping("/Transaction/Get/{id}")
	public ITransaction getTransaction(@PathVariable("id") int id)
	{
		return dataControl.getTransaction(id);
	}
	
	@GetMapping("/Transaction/GetAll")
	public void getTransactions()
	{
		tDataControl.getUserTransactions();
	}
	
	@PostMapping("/Transaction/Payment/{service}/{amount}")
	public void newPaymentTransaction(@PathVariable("service") String service, @PathVariable("amount") int amount)
	{
		tDataControl.newPaymentTransaction(service, amount);
	}
	
	@PostMapping("/Transaction/Wallet/{amount}")
	public void newWalletTransaction(@PathVariable("amount") int amount)
	{
		String service = "Wallet";
		ITransaction transaction = new WalletTransaction(getCurrentUID(), service, amount);
		SaveTranscation(transaction);
	}
	
	@PostMapping("/Transaction/Refund/{id}/{amount}")
	public void newRefundTransaction(@PathVariable("id") int id, @PathVariable("amount") int amount)
	{
		String service = "Refund";
		ITransaction transaction = new RefundTransaction(id, service, amount);
		SaveTranscation(transaction);
	}
	
	@GetMapping("/Transaction/GetPay")
	public void getPayTransactions()
	{
		tDataControl.getUserPayTransactions();
	}
}
