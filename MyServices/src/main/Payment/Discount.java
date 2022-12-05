package main.Payment;


import java.util.Iterator;

import main.Data.Data;

public class Discount {
	Data data = Data.getInstance();
	
	public boolean serviceDiscount(String ServiceName)
	{
		String ServiceN;
		Iterator<String> itr = data.getDiscountedServices().iterator();
		while(itr.hasNext())
		{
			ServiceN = itr.next();
			if(ServiceN == ServiceName)
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
			int UID = Integer.parseInt(itr.next());
			if(id == UID)
			{
				return true;
			}
		}
		return false;
	}
	
}
