package com.MyServices.Main.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Payment.Payment;
import com.MyServices.Main.Payment.PaymentControl;
import com.MyServices.Main.User.CurrentUser;

@RestController
public class ServiceControl
{
	String serviceName;
	PaymentControl paymentControl = new PaymentControl();
	int UID, Amount;
	
	@GetMapping("/Service/User/ID")
	public void getCurrentUID()
	{
		UID = CurrentUser.currentUser.getUserID();
	}
	
	@PostMapping("/Service/Pay/{id}/{service}/{amount}")
	public Payment ServicePay(@PathVariable("id") int UID, @PathVariable("service") String ServiceName, @PathVariable("amount") int amount)
	{
		return paymentControl.startPayment(UID, ServiceName, amount);
	}
	
	@PostMapping("/Service/MobileRecharge/{choice}")
	public Payment MobileRechargeSPMenu(@PathVariable("choice") int choice)
	{
		IFactoryServices factoryServices = new MobileRecharge();
		
		switch (choice) 
		{
			case 1:
			{
				
				//E
				factoryServices.CreateEtisalatForm().EtisalatForm();
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 2:
			{
				//O
				factoryServices.CreateOrangeForm().OrangeForm();
				serviceName = factoryServices.CreateOrangeForm().returnServiceName();
				Amount = factoryServices.CreateOrangeForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 3:
			{
				//V
				factoryServices.CreateVodafoneForm().VodafoneForm();
				serviceName = factoryServices.CreateVodafoneForm().returnServiceName();
				Amount = factoryServices.CreateVodafoneForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 4:
			{
				//W
				factoryServices.CreateWeForm().WeForm();
				serviceName = factoryServices.CreateWeForm().returnServiceName();
				Amount = factoryServices.CreateWeForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	@PostMapping("/Service/InternetPayment/{choice}")
	public Payment InternetPaymentSPMenu(@PathVariable("choice") int choice)
	{
		IFactoryServices factoryServices = new InternetPayment();
		
		switch (choice) 
		{
			case 1:
			{
				//E
				factoryServices.CreateEtisalatForm().EtisalatForm();
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 2:
			{
				//O
				factoryServices.CreateOrangeForm().OrangeForm();
				serviceName = factoryServices.CreateOrangeForm().returnServiceName();
				Amount = factoryServices.CreateOrangeForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 3:
			{
				//V
				factoryServices.CreateVodafoneForm().VodafoneForm();
				serviceName = factoryServices.CreateVodafoneForm().returnServiceName();
				Amount = factoryServices.CreateVodafoneForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 4:
			{
				//W
				factoryServices.CreateWeForm().WeForm();
				serviceName = factoryServices.CreateWeForm().returnServiceName();
				Amount = factoryServices.CreateWeForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	@PostMapping("/Service/Landline/{choice}")
	public Payment LandlineSPMenu(@PathVariable("choice") int choice)
	{
		Landline landline;
		
		switch (choice) 
		{
			case 1:
			{
				//m
				landline = new MonthlyLL();
				landline.LandLineForm();
				serviceName = landline.returnServiceName();
				Amount = landline.returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 2:
			{
				//q
				landline = new QuarterlyLL();
				landline.LandLineForm();
				serviceName = landline.returnServiceName();
				Amount = landline.returnAmount();
				return ServicePay(UID, serviceName, Amount);	
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	@PostMapping("/Service/Donations/{choice}")
	public Payment DonationsSPMenu(@PathVariable("choice") int choice)
	{
		Donations donations;
		switch (choice) 
		{
			case 1:
			{
				donations = new Schools();
				donations.DonationForm();
				serviceName = donations.returnServiceName();
				Amount = donations.returnAmount();
				return ServicePay(UID, serviceName, Amount);
				//s
			}
			case 2:
			{
				donations = new Hospitals();
				donations.DonationForm();
				serviceName = donations.returnServiceName();
				Amount = donations.returnAmount();
				return ServicePay(UID, serviceName, Amount);
				//H
			}
			case 3:
			{
				donations = new NGOs();
				donations.DonationForm();
				serviceName = donations.returnServiceName();
				Amount = donations.returnAmount();
				return ServicePay(UID, serviceName, Amount);
				//NGOs
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}	
}
