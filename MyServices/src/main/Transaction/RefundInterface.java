package main.Transaction;

import java.util.Iterator;
import java.util.Scanner;

import main.Payment.WalletControl;

public class RefundInterface extends RefundControl {

	TransactionControl transactionControl;
	Scanner scanner = new Scanner(System.in);
	WalletControl walletControl = new WalletControl();
	
	public RefundInterface() {
		transactionControl = new TransactionControl();
	}
	
	public void RequestForm()
	{
		transactionControl.getPayTransactions();
		System.out.print("Enter the TransactionID: ");
		int transId = scanner.nextInt();
		
		RequestRefund(transactionControl.getTransaction(transId));
		System.out.println("Refund Request Submitted");
	}
	
	public void DisplayRefundRequests()
	{
		getRefundRequests();
	}
	
	public void processRefundForm()
	{
		System.out.println("Refund Processing Menu");
		Iterator<Refund> itr = data.getRefundRequest().iterator();
		Refund refund;
		while(itr.hasNext())
		{
			refund = itr.next();
			if(refund.getRefundStatus().equals("Pending Review"))
			{
				refund.printRefund();
				System.out.println("1- Approve");
				System.out.println("2- Reject");
				System.out.print("Choice: ");
				int choice = scanner.nextInt();	
				
				if (choice == 1)
				{
					refund.setRefundStatus("Approved");
					walletControl.addfunds(refund.getRefundTransaction().getAmount());
					refund.setFlag(true);
				}
				
				if (choice == 2)
				{
					refund.setRefundStatus("Rejected");
					refund.setFlag(false);
				}
			}
		}
	}
}
