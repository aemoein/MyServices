package main.Payment;

public class Payment {
	private int UID;
	private String serviceName;
	private int amount;
	
	public Payment(int UID, String service, int amount) 
	{
		this.UID = UID;
		this.serviceName = service;
		this.amount = amount;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
