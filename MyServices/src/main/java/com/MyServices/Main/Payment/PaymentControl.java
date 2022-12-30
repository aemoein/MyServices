package com.MyServices.Main.Payment;

import com.MyServices.Main.Transaction.TransactionControl;

public class PaymentControl extends Discount{

	PaymentMethod paymentMethod;
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
			bill.setAmount(billSerDisBill.getBill());
			
			if (overallDiscount(payment.getUID()))
			{
				Bill billOverallDisBill = new ServiceDiscount(bill);
				System.out.println("Service & Overall Discount Applied");
				payment.setAmount(billOverallDisBill.getBill()); 
			}
			else 
			{
				System.out.println("Service Discount Applied");
				payment.setAmount(billSerDisBill.getBill());
			}
		}
		
		else if (overallDiscount(payment.getUID()))
		{
			Bill billOverallDisBill = new ServiceDiscount(bill);
			System.out.println("Overall Discount Applied");
			payment.setAmount(billOverallDisBill.getBill());
		}
		
		else 
		{
			System.out.println("No Discount Applied");
			payment.setAmount(bill.getBill());
		}
	}
	
	public void CashPayment(Payment payment)
	{
		paymentMethod = new Cash();
		paymentMethod.pay(payment.getAmount());
	}
	
	public void CreditCardPayment(Payment payment)
	{
		paymentMethod = new Credit_Card();
		paymentMethod.pay(payment.getAmount());
	}
	
	public boolean WalletPayment(Payment payment)
	{
		paymentMethod = new WalletPay();
		return paymentMethod.pay(payment.getAmount());
	}
	
	public void createTransaction(Payment payment)
	{
		TransactionControl tControl = new TransactionControl();
		tControl.newPaymentTransaction(payment.getServiceName(), payment.getAmount());
		System.out.println("Transaction Completed Successfully");
	}
}
