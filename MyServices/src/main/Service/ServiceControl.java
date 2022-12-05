package main.Service;

import main.Payment.Payment;
import main.Payment.PaymentControl;
import main.User.UserControl;

public class ServiceControl extends PaymentControl
{
	String serviceName;
	int UID, Amount;
	
	public void getCurrentUID()
	{
		UserControl userControl = new UserControl();
		UID = userControl.getCurrentUser().getUserID();
	}
	
	public Payment ServicePay(int UID, String ServiceName, int amount)
	{
		return startPayment(UID, ServiceName, amount);
	}
	
	public Payment MobileRechargeSPMenu(int choice)
	{
		IFactoryServices factoryServices = new MobileRecharge();
		
		switch (choice) 
		{
			case 1:
			{
				
				//E
				factoryServices.CreateEtisalatForm().EtisalatForm();
				serviceName = factoryServices.CreateEtisalatForm().returnServiceName();
				System.out.println("ServiceNameCheck: " + serviceName);
				Amount = factoryServices.CreateEtisalatForm().returnAmount();
				System.out.println("AmountCheck: " + Amount);
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
	
	public Payment InternetPaymentSPMenu(int choice)
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
	
	public Payment LandlineSPMenu(int choice)
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
	
	public Payment DonationsSPMenu(int choice)
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
