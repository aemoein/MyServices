package com.MyServices.Main.Payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Transaction.TransactionControl;

@RestController
public class PaymentControl{

	
	PaymentMethod paymentMethod;
	Discount discount = new Discount();
	
	
	@PostMapping("/Payment/Start/{id}/{service}/{amount}")
	public Payment startPayment(@PathVariable("id") int UID, @PathVariable("service") String service, @PathVariable("amount") int amount)
	{
		Payment payment = new Payment(UID, service, amount);
		return payment;
	}
	
	
	@GetMapping("/Payment/Bill/{id}/{serviceName}/{amount}")
	public int getBill( @PathVariable("id") int UID, @PathVariable("serviceName") String service, @PathVariable("amount") int amount)
	{
		Payment payment = startPayment(UID, service, amount);
		Bill bill = new ConcreteBill(payment.getServiceName() ,payment.getAmount());
		
		if (discount.serviceDiscount(payment.getServiceName()))
		{
			Bill billSerDisBill = new ServiceDiscount(bill);
			bill.setAmount(billSerDisBill.getBill());
			
			if (discount.overallDiscount(payment.getUID()))
			{
				Bill billOverallDisBill = new ServiceDiscount(bill);
				System.out.println("Service & Overall Discount Applied");
				return billOverallDisBill.getBill(); 
			}
			else 
			{
				System.out.println("Service Discount Applied");
				return billSerDisBill.getBill();
			}
		}
		
		else if (discount.overallDiscount(payment.getUID()))
		{
			Bill billOverallDisBill = new ServiceDiscount(bill);
			System.out.println("Overall Discount Applied");
			return billOverallDisBill.getBill();
		}
		
		else 
		{
			System.out.println("No Discount Applied");
			return bill.getBill();
		}
	}
	
	
	@PostMapping("/Payment/Cash/{amount}")
	public void CashPayment(int amount)
	{
		paymentMethod = new Cash();
		paymentMethod.pay(amount);
	}
	
	
	@PostMapping("/Payment/Credit/{amount}")
	public void CreditCardPayment(int amount)
	{
		paymentMethod = new Credit_Card();
		paymentMethod.pay(amount);
	}
	
	
	@PostMapping("/Payment/WalletPay/{amount}")
	public boolean WalletPayment(int amount)
	{
		paymentMethod = new WalletPay();
		return paymentMethod.pay(amount);
	}
	
	
	@PostMapping("/Payment/Transaction/{id}/{service}/{amount}")
	public String createTransaction(@PathVariable("id") int UID, @PathVariable("service") String service, @PathVariable("amount") int amount)
	{
		Payment payment = new Payment(UID, service, amount);   //startPayment(UID, service, amount);
		TransactionControl tControl = new TransactionControl();
		tControl.newPaymentTransaction(payment.getServiceName(), payment.getAmount());
		System.out.println("Transaction Completed Successfully");
		return "Transaction Completed Successfully";
	}
}
