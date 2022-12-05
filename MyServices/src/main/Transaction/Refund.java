package main.Transaction;

import main.User.UserControl;

public class Refund extends RefundControl 
{
	private UserControl userControl = new UserControl();
	private static int RefundId;
	private int UID;
	private String RefundStatus;
	
	ITransaction refundTransaction;
	
	public Refund(ITransaction refundTransaction) 
	{
		RefundStatus = "Pending Review";
		UID = userControl.getCurrentUser().getUserID();
		RefundId++;
		this.refundTransaction = refundTransaction;
	}
	
	public void printRefund()
	{
		System.out.println("RefundID: " + RefundId + " Refund Status: " + RefundStatus);
		refundTransaction.printTransaction();
	}

	public String getRefundStatus() {
		return RefundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		RefundStatus = refundStatus;
	}

	public static int getRefundId() {
		return RefundId;
	}

	public static void setRefundId(int refundId) {
		RefundId = refundId;
	}
	
	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

}
