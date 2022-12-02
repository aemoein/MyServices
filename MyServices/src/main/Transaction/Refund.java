package main.Transaction;

public class Refund {
	private static int RefundId;
	Transaction refundTransaction;
	
	public Refund(Transaction refundTransaction) {
		RefundId++;
		this.refundTransaction = refundTransaction;
	}
}
