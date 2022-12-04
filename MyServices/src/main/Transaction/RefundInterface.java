package main.Transaction;

import java.util.Scanner;

public class RefundInterface extends RefundControl {

	TransactionControl transactionControl;
	
	public RefundInterface() {
		transactionControl = new TransactionControl();
	}
	
	public void RequestForm()
	{
		transactionControl.getTransactions(0);
		Scanner scanner = new Scanner(System.in);
		int transId = scanner.nextInt();
		RequestRefund(transactionControl.getTransaction(transId));
	}
}
