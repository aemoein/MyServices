package main.Transaction;

public class Refund extends RefundControl {
	private static int RefundId;
	Transaction refundTransaction;
	
	public Refund(Transaction refundTransaction) {
		RefundId++;
		this.refundTransaction = refundTransaction;
	}
}
