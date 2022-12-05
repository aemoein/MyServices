package main.Data;

import java.util.Iterator;

import main.Transaction.ITransaction;
import main.Transaction.Refund;
import main.User.User;

public class DataControl 
{
	public void DisplayData(int c)
	{
		Data data = Data.getInstance();
		switch (c) 
		{
			case 1: 
			{
				Iterator<User> itr = data.getUsers().iterator();
				while (itr.hasNext()) 
				{
					itr.next().display();
				}
				break;
			}
			
			case 2: 
			{
				if ( data.getTransactions().isEmpty())
				{
					System.out.println("NO TRANSACTIONS AVALIABLE");
				}
				
				else
				{
					System.out.println("userId"+"\t"+"TransactionID"+"\t"+"Service"+"\t\t\t\t"+"$"+"amount"+"\t\t"+"type");
					Iterator<ITransaction> itr = data.getTransactions().iterator();
					ITransaction transaction;
					while(itr.hasNext())
					{   transaction = itr.next();
						transaction.printTransaction();
					}
				}
				break;
			}
			
			case 3: 
			{
				if ( data.getPayTransactions().isEmpty())
				{
					System.out.println("NO TRANSACTIONS AVALIABLE");
				}
				
				else
				{
					System.out.println("userId"+"\t"+"TransactionID"+"\t"+"Service"+"\t\t\t"+"$"+"amount"+"\t"+"type");
					Iterator<ITransaction> itr = data.getPayTransactions().iterator();
					ITransaction transaction;
					while(itr.hasNext())
					{   transaction = itr.next();
						transaction.printTransaction();
					}
				}
				break;
			}
			
			case 4: 
			{
				String ServiceN;
				Iterator<String> itr = data.getDiscountedServices().iterator();
				while(itr.hasNext())
				{
					ServiceN = itr.next();
					System.out.println(ServiceN);
				}
				break;
			}
			
			case 5: 
			{
				Iterator<String> itr = data.getDiscountedUsers().iterator();
				while(itr.hasNext())
				{
					int UID = Integer.parseInt(itr.next());
					System.out.println(UID);
				}
				break;
			}
			
			case 6: 
			{
				Iterator<Refund> itr = data.getRefundRequest().iterator();
				Refund refund;
				while(itr.hasNext())
				{
					refund = itr.next();
					refund.printRefund();
				}
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + c);
		}
	}
}
