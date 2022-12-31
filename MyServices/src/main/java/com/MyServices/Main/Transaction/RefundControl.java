package com.MyServices.Main.Transaction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Data.DataControl;
import com.MyServices.Main.Payment.WalletControl;

@RestController
public class RefundControl
{
	DataControl dataControl = new DataControl();
	WalletControl walletControl = new WalletControl();
	TransactionControl transactionControl = new TransactionControl();
	
	@GetMapping("/Transaction/Refund/Request")
	public void RequestRefund(@RequestBody ITransaction refundTransaction)
	{
		dataControl.RequestRefund(refundTransaction);
	}
	
	@GetMapping("/Transaction/Refund/Display")
	public void getRefundRequests()
	{
		dataControl.getUserRefundRequests();
	}
	
	@GetMapping("/Transaction/Refund/Create")
	public void createRefundTransaction(@RequestBody Refund refund)
	{
		walletControl.refundAmount(refund.getUID() ,refund.getRefundTransaction().getAmount());
		transactionControl.newRefundTransaction(refund.getUID() ,refund.getRefundTransaction().getAmount());	
	}
}