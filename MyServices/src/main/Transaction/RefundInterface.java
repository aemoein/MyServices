package main.Transaction;

import java.util.Scanner;

public class RefundInterface extends RefundControl {

	TransactionControl transactionControl;
	Scanner scanner = new Scanner(System.in);
	
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
}
