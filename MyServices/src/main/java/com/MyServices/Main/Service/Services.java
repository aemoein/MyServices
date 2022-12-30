package com.MyServices.Main.Service;

public class Services extends ServiceControl{
	
	private IFactoryServices factoryServices;
	
	private Orange orange;
	private We we;
	private Vodafone vodafone;
	private Etisalat etisalat;
	
	public Services (IFactoryServices factoryServices)
	{
		this.factoryServices = factoryServices;
	}
	
	public void CreateService(IFactoryServices service)
	{
		this.etisalat = factoryServices.CreateEtisalatForm();
		this.orange = factoryServices.CreateOrangeForm();
		this.vodafone = factoryServices.CreateVodafoneForm();
		this.we = factoryServices.CreateWeForm();
	}
	
	public void WeForm()
	{
		we.WeForm();
	}
	public void VodafoneForm()
	{
		vodafone.VodafoneForm();
	}
	public void EtisalatForm()
	{
		etisalat.EtisalatForm();
	}
	public void OrangeForm()
	{
		orange.OrangeForm();
	}
	///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	private Donations donations;
	
	public void setDonationStrategy(Donations donations)
	{
		this.donations = donations;
	}
	
	public void DonationForm()
	{
		donations.DonationForm();
	}
	///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	private Landline landline;
	
	public void setLandLineStartegy(Landline landline)
	{
		this.landline = landline;
	}
	
	public void LandLineForm()
	{
		landline.LandLineForm();
	}
	///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	

}
