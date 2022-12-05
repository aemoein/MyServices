package main.Service;

import main.Payment.Payment;
import main.Payment.PaymentControl;

public class ServiceControl extends PaymentControl
{
	public Payment ServicePay(int UID, String ServiceName, int amount)
	{
		return startPayment(UID, ServiceName, amount);
	}
	
	public Payment MobileRechargeSPMenu(int choice)
	{
		IFactoryServices factoryServices = new MobileRecharge();
		String serviceName;
		int UID = 0, Amount;
		
		
		switch (choice) 
		{
			case 1:
			{
				//E
				factoryServices.CreateEtisalatForm().EtisalatForm();;
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 2:
			{
				//O
				factoryServices.CreateOrangeForm().OrangeForm();
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 3:
			{
				//V
				factoryServices.CreateVodafoneForm().VodafoneForm();
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 4:
			{
				//W
				factoryServices.CreateWeForm().WeForm();
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	public Payment InternetPaymentSPMenu(int choice)
	{
		IFactoryServices factoryServices = new InternetPayment();
		String serviceName;
		int UID = 0, Amount;
		
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
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 3:
			{
				//V
				factoryServices.CreateVodafoneForm().VodafoneForm();
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			case 4:
			{
				//W
				factoryServices.CreateWeForm().WeForm();
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				return ServicePay(UID, serviceName, Amount);
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	public Payment LandlineSPMenu(int choice)
	{
		Landline landline;
		String serviceName;
		int UID = 0, Amount;
		
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
	
	public Payment DonationsSPMenu(int choice)
	{
		Donations donations;
		String serviceName;
		int UID = 0, Amount;
		
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
