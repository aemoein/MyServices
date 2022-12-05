package main.Payment;

import main.Transaction.TransactionControl;

public class PaymentControl extends Discount{

	public Payment startPayment(int UID, String service, int amount)
	{
		Payment payment = new Payment(UID, service, amount);
		return payment;
	}
	
	public void getBill(Payment payment)
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
				payment.setAmount(billOverallDisBill.getAmount()); 
			}
			else 
			{
				billSerDisBill.getbill();
				System.out.println("Service Discount Applied");
				payment.setAmount(billSerDisBill.getAmount());
			}
		}
		
		else if (overallDiscount(payment.getUID()))
		{
			Bill billOverallDisBill = new ServiceDiscount(bill);
			billOverallDisBill.getbill();
			System.out.println("Overall Discount Applied");
			payment.setAmount(billOverallDisBill.getAmount());
		}
		
		else 
		{
			bill.getbill();
			System.out.println("No Discount Applied");
			payment.setAmount(bill.getAmount());
		}
	}
	
	public void payBill(Payment payment, int choice)
	{
		PaymentMethod paymentMethod;
		switch (choice) 
		{
			case 1: 
			{
				paymentMethod = new Cash();
				paymentMethod.pay(payment.getAmount());
			}
			case 2: 
			{
				paymentMethod = new Credit_Card();
				paymentMethod.pay(payment.getAmount());
			}
			case 3: 
			{
				paymentMethod = new WalletPay();
				paymentMethod.pay(payment.getAmount());
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	public void createTransaction(Payment payment)
	{
		TransactionControl tControl = new TransactionControl();
		tControl.newPaymentTransaction(payment.getUID(), payment.getServiceName(), payment.getAmount());
		System.out.println("Transaction Completed Successfully");
	}
}
