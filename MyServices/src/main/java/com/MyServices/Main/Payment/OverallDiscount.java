package com.MyServices.Main.Payment;

public class OverallDiscount extends BillDecorator
{
	public OverallDiscount(Bill decoratedBill) {
		super(decoratedBill);
	}
	
	@Override
	public int getBill() {
		// TODO Auto-generated method stub
		return addOverallDiscount(DecoratedBill);
	}
	
	private int addOverallDiscount(Bill decoratedBill) {
		int amount = decoratedBill.getAmount();
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
	public void setAmount(int amount) {
		// TODO Auto-generated method stub
		
	}
}