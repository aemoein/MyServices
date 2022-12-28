package com.MyServices.Payment;

public class ServiceDiscount extends BillDecorator {

	public ServiceDiscount(Bill decoratedBill) {
		super(decoratedBill);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getBill() {
		// TODO Auto-generated method stub
		return addServiceDiscount();
	}
	
	public int addServiceDiscount() 
	{
		int amount = DecoratedBill.getAmount();
		double perc = 0.2;
		amount =(int) (amount - (amount * perc));
		return amount;
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return DecoratedBill.getAmount();
	}

	@Override
	public void setAmount() {
		// TODO Auto-generated method stub
		
	}
}
