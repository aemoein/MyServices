package main.Payment;

public abstract class BillDecorator implements Bill{
	
	protected Bill DecoratedBill;
	private String billService;
	private int billAmount;
	
	public BillDecorator(Bill decoratedBill)
	{
		this.DecoratedBill = decoratedBill;
	}
	
	@Override
	public void getbill()
	{
		DecoratedBill.getbill();
	}

	public String getBillService() {
		return billService;
	}

	public void setBillService(String billService) {
		this.billService = billService;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}	
}
