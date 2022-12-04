package main.Payment;

public class PaymentControl extends Discount{
	
	public void getBill(String service, int UID, int amount)
	{
		Bill bill = new ConcreteBill(service,amount);
		
		if (serviceDiscount(service))
		{
			Bill billSerDisBill = new ServiceDiscount(bill);
			
			if (overallDiscount(UID))
			{
				Bill billOverallDisBill = new ServiceDiscount(billSerDisBill);
				billOverallDisBill.getbill();
				System.out.println("Service & Overall Discount Applied");
			}
			else 
			{
				billSerDisBill.getbill();
				System.out.println("Service Discount Applied");
			}
		}
		
		else if (overallDiscount(UID))
		{
			Bill billOverallDisBill = new ServiceDiscount(bill);
			billOverallDisBill.getbill();
			System.out.println("Overall Discount Applied");
		}
		
		else 
		{
			bill.getbill();
			System.out.println("No Discount Applied");
		}
	}	
}
