package main.Payment;

public class WalletPay implements PaymentMethod
{
	private WalletControl walletControl = new WalletControl();
	
	@Override
	public void pay(int amountPaid) 
	{
		int currAmount =  walletControl.getwallet(0).getAmount();
		if (amountPaid > currAmount)
		{
			System.out.println("Insufficient Funds Choose another Method");
		}
		else 
		{
			currAmount = currAmount - amountPaid;
			walletControl.getwallet(0).setAmount(currAmount);
			System.out.println("Ammount Successfully paid");
			System.out.print("New Balance is: ");
			walletControl.getwallet(0).getAmount();
		}
	}

}
