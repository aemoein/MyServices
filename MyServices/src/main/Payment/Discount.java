package main.Payment;


import java.util.Iterator;

import main.Data.Data;

public class Discount {
	Data data = Data.getInstance();
	
	public boolean serviceDiscount(String ServiceName)
	{
		Iterator<String> itr = data.getDiscountedServices().iterator();
		while(itr.hasNext())
		{
			if(itr.next() == ServiceName)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean overallDiscount(int id)
	{
		Iterator<String> itr = data.getDiscountedUsers().iterator();
		while(itr.hasNext())
		{
			if(id == Integer.parseInt(itr.next()))
			{
				return true;
			}
		}
		return false;
	}
	
}
