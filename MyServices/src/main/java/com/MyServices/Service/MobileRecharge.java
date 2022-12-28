package com.MyServices.Service;

public class MobileRecharge implements IFactoryServices {

	@Override
	public We CreateWeForm() {
		WeMobileRecharge WeMobile = new WeMobileRecharge();
		return WeMobile;
	}

	@Override
	public Vodafone CreateVodafoneForm() {
		VodafoneMobileRecharge VodafoneMobile = new VodafoneMobileRecharge();
		return VodafoneMobile;
	}

	@Override
	public Etisalat CreateEtisalatForm() {
		EtisalatMobileRecharge EtisalatMobile = new EtisalatMobileRecharge();
		return EtisalatMobile;
	}

	@Override
	public Orange CreateOrangeForm() {
		OrangeMobileRecharge OrangeMobile = new OrangeMobileRecharge();
		return OrangeMobile;
	}
	

}
