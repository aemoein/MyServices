package main.User;

public class AdminControl 
{
	public String SelectService(int c)
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
				ServiceName = "Orange Mobile Recharge";
				return ServiceName;
			}
			
			case 3: 
			{
				ServiceName = "Vodafone Mobile Recharge";
				return ServiceName;
			}
			
			case 4: 
			{
				ServiceName = "We Mobile Recharge";
				return ServiceName;
			}
			
			case 5: 
			{
				ServiceName = "Etisalat Internet Payment";
				return ServiceName;
			}
			
			case 6: 
			{
				ServiceName = "Orange Internet Payment";
				return ServiceName;
			}
			
			case 7: 
			{
				ServiceName = "Vodafone Internet Payment";
				return ServiceName;
			}
			
			case 8: 
			{
				ServiceName = "We Internet Payment";
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
}
