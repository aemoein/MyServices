package main.Transaction;

import java.util.Scanner;

import main.Input;
import main.Data.DataControl;
import main.Payment.WalletControl;

public class RefundInterface extends RefundControl {

	TransactionControl transactionControl;
	DataControl dataControl = new DataControl();
	Scanner scanner = new Scanner(System.in);
	WalletControl walletControl = new WalletControl();
	
	public RefundInterface() {
		transactionControl = new TransactionControl();
	}
	
	public void RequestForm()
	{
		System.out.println();
		transactionControl.getPayTransactions();
		System.out.println();
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
		boolean flag = true;
		System.out.println();
		System.out.println("Refund Processing Menu");
		Refund refund = dataControl.getPendingRefund();
		do 
		{	if (refund == null)
			{
				flag = false;
				break;
			}
			refund.printRefund();
			System.out.println("1- Approve");
			System.out.println("2- Reject");
			
			switch (Input.inputInt(scanner))
			{
				case 1: 
				{
					refund.setRefundStatus("Approved");
					walletControl.addfunds(refund.getRefundTransaction().getAmount());
					refund.setFlag(true);
					flag = false;
				}
				
				case 2: 
				{
					refund.setRefundStatus("Rejected");
					refund.setFlag(false);
					flag = false;
				}
				default:
					System.out.println("PLEASE ENTER A VALID OPTION");
					break;
			}
		}while (flag == true);
	}
	
	public void refundForm()
	{
		boolean flag = true;
		do {
			System.out.println();
			System.out.println("REFUND MENU");
			System.out.println("Choose From The Options Below");
			System.out.println("1- Request A Refund");
			System.out.println("2- Check A Refund Request");
			
			switch (Input.inputInt(scanner))
			{
				case 1: 
				{
					RequestForm();
					flag = false;
					break;
				}
				
				case 2: 
				{
					DisplayRefundRequests();
					flag = false;
					break;
				}
				default:
					System.out.println("PLEASE ENTER A VALID OPTION");
					break;
			}
		}while (flag);
	}
}
