package main.Payment;

public class ServiceDiscount extends BillDecorator {

	public ServiceDiscount(Bill decoratedBill) {
		super(decoratedBill);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void getbill() {
		// TODO Auto-generated method stub
		addServiceDiscount(DecoratedBill);
		DecoratedBill.getbill();
	}
	
	private void addServiceDiscount(Bill decoratedBill)
	{
		int amount = getBillAmount();
		amount = (int) (amount - (amount * 0.2));
		setBillAmount(amount);
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return DecoratedBill.getAmount();
	}
}
