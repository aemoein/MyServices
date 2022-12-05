package main.Payment;

import main.Transaction.TransactionControl;

public class PaymentControl extends Discount{

	public Payment startPayment(int UID, String service, int amount)
	{
		Payment payment = new Payment(UID, service, amount);
		return payment;
	}
	
	public int getBill(Payment payment)
	{
		Bill bill = new ConcreteBill(payment.getServiceName() ,payment.getAmount());
		
		if (serviceDiscount(payment.getServiceName()))
		{
			Bill billSerDisBill = new ServiceDiscount(bill);
			
			if (overallDiscount(payment.getUID()))
			{
				Bill billOverallDisBill = new ServiceDiscount(billSerDisBill);
				billOverallDisBill.getbill();
				System.out.println("Service & Overall Discount Applied");
				return billOverallDisBill.getAmount();
			}
			else 
			{
				billSerDisBill.getbill();
				System.out.println("Service Discount Applied");
				return billSerDisBill.getAmount();
			}
		}
		
		else if (overallDiscount(payment.getUID()))
		{
			Bill billOverallDisBill = new ServiceDiscount(bill);
			billOverallDisBill.getbill();
			System.out.println("Overall Discount Applied");
			return billOverallDisBill.getAmount();
		}
		
		else 
		{
			bill.getbill();
			System.out.println("No Discount Applied");
			return bill.getAmount();
		}
	}
	
	public void payBill(int amount, int choice)
	{
		PaymentMethod paymentMethod;
		switch (choice) 
		{
			case 1: 
			{
				paymentMethod = new Cash();
				paymentMethod.pay(amount);
			}
			case 2: 
			{
				paymentMethod = new Credit_Card();
				paymentMethod.pay(amount);
			}
			case 3: 
			{
				paymentMethod = new WalletPay();
				paymentMethod.pay(amount);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	public void createTransaction(int UID, String service, int amount)
	{
		TransactionControl tControl = new TransactionControl();
		tControl.newPaymentTransaction(UID, service, amount);
		System.out.println("Transaction Completed Successfully");
	}
	
	public void getService()
	{
		
	}
}
