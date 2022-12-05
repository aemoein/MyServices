package main.Payment;

public class ConcreteBill implements Bill{

	private String Service;
	private int amount;
	
	public ConcreteBill(String service, int amount) {
		this.Service = service;
		this.amount = amount;
	}
	
	@Override
	public void getbill() 
	{
		
	}

	public String getService() {
		return Service;
	}

	public void setService(String service) {
		Service = service;
	}

	@Override
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
