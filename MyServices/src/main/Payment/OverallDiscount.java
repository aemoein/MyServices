package main.Payment;

public class OverallDiscount extends BillDecorator{

	public OverallDiscount(Bill decoratedBill) {
		super(decoratedBill);
	}
	
	@Override
	public void getbill() {
		// TODO Auto-generated method stub
		addOverallDiscount(DecoratedBill);
		DecoratedBill.getbill();
	}
	
	private void addOverallDiscount(Bill decoratedBill)
	{
		int amount = getBillAmount();
		amount = (int) (amount - (amount * 0.2));
		setBillAmount(amount);
	}
}