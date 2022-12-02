package main.Transaction;

import java.util.Scanner;

public class RefundInterface {

	RefundControl refundControl;
	TransactionControl transactionControl;
	
	public RefundInterface() {
		refundControl = new RefundControl();
		transactionControl = new TransactionControl();
	}
	
	public void RequestForm()
	{
		transactionControl.getTransactions(0);
		Scanner scanner = new Scanner(System.in);
		int transId = scanner.nextInt();
		refundControl.RequestRefund(transactionControl.getTransaction(transId));
	}
}
