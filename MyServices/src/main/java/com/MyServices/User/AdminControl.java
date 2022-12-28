package com.MyServices.User;

import com.MyServices.Data.DataControl;

public class AdminControl 
{
	DataControl dataControl = new DataControl();
;	public String SelectService(int c)
	{
		String ServiceName;
		switch (c) 
		{
			case 1: 
			{
				ServiceName = "Etisalat Mobile Recharge";
				return ServiceName;
			}
			
			case 2: 
			{
				ServiceName = "Orange Mobile Recharge\t";
				return ServiceName;
			}
			
			case 3: 
			{
				ServiceName = "Vodafone Mobile Recharge";
				return ServiceName;
			}
			
			case 4: 
			{
				ServiceName = "We Mobile Recharge\t";
				return ServiceName;
			}
			
			case 5: 
			{
				ServiceName = "Etisalat Internet Payment";
				return ServiceName;
			}
			
			case 6: 
			{
				ServiceName = "Orange Internet Payment\t";
				return ServiceName;
			}
			
			case 7: 
			{
				ServiceName = "Vodafone Internet Payment";
				return ServiceName;
			}
			
			case 8: 
			{
				ServiceName = "We Internet Payment\t";
				return ServiceName;
			}
			
			case 9: 
			{
				ServiceName = "Monthly Landline Payment";
				return ServiceName;
			}
			
			case 10: 
			{
				ServiceName = "Quarterly Landline Payment";
				return ServiceName;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + c);
		}
		
	}
	
	public void AddServiceDiscount(int choice)
	{
		dataControl.AddServiceDiscount(SelectService(choice));
	}
	
	public void AddUserDiscount(String id)
	{
		dataControl.AddUserDiscount(id);
	}
	
	public void DisplayAllUsers()
	{
		dataControl.DisplayAllUsers();
	}
}
