package com.MyServices.Main.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Data.DataControl;

@RestController
public class AdminControl 
{
	DataControl dataControl = new DataControl();
	
	@GetMapping("/Admin/SelectService/{c}")
	public String SelectService(@PathVariable("c") int c)
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
	
	@PostMapping("/Admin/Add/ServiceDiscount/{c}")
	public void AddServiceDiscount(@PathVariable("c") int choice)
	{
		dataControl.AddServiceDiscount(SelectService(choice));
	}
	
	@PostMapping("/Admin/Add/UserDiscount/{id}")
	public void AddUserDiscount(@PathVariable("id") String id)
	{
		dataControl.AddUserDiscount(id);
	}
	
	@GetMapping("/Admin/Display/AllUsers")
	public void DisplayAllUsers()
	{
		dataControl.DisplayAllUsers();
	}
	
	@GetMapping("/Admin/Display/AllServices")
	public void DisplayAllAvaliableServices() 
	{
		System.out.println("1- Etisalat Mobile Recharge");
		System.out.println("2- Orange Mobile Recharge");
		System.out.println("3- Vodafone Mobile Recharge");
		System.out.println("4- We Mobile Recharge");
		System.out.println("5- Etisalat Internet Payment");
		System.out.println("6- Orange Internet Payment");
		System.out.println("7- Vodafone Internet Payment");
		System.out.println("8- We Internet Payment");
		System.out.println("9- Monthly Landline Payment");
		System.out.println("10- Quarterly Landline Payment");
	}
}
