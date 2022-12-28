package com.MyServices.Service;

public class InternetPayment implements IFactoryServices{

	@Override
	public We CreateWeForm() {
		WeInternetPayment WeNet = new WeInternetPayment();
		return WeNet;
	}

	@Override
	public Vodafone CreateVodafoneForm() {
		VodafoneInternetPayment vodaNet = new VodafoneInternetPayment();
		return vodaNet;
	}

	@Override
	public Etisalat CreateEtisalatForm() {
		EtisalatInternetPayment EtisalatNet = new EtisalatInternetPayment();
		return EtisalatNet;
	}

	@Override
	public Orange CreateOrangeForm() {
		OrangeInternetPayment OrangeNet = new OrangeInternetPayment();
		return OrangeNet;
	}

}
