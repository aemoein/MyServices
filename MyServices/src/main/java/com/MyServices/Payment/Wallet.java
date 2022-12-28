package com.MyServices.Payment;

public class Wallet {
	
	private int UID;
	private int amount = 0;
	
	public Wallet(int UID, int amount)
	{
		this.UID = UID;
		this.amount = amount;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
