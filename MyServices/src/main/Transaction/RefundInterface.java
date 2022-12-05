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
		transactionControl.getTransactions();
		int transId = scanner.nextInt();
		RequestRefund(transactionControl.getTransaction(transId));
	}
	
	public void DisplayRefundRequests()
	{
		
	}
}
