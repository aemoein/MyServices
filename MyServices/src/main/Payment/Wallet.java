package main.Payment;

public class Wallet extends WalletControl{
	private int userid;
	private int amount;
	
	public Wallet()
	{
		amount = 0;
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
