package main.Payment;

public class Wallet {
	private int userid;
	private int amount = 0;
	
	public Wallet()
	{
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
