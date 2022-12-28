package com.MyServices.Payment;

import com.MyServices.Data.DataControl;

public class Discount {
	DataControl dataControl = new DataControl();
	
	public boolean serviceDiscount(String ServiceName)
	{
		return dataControl.ServiceDiscountCheck(ServiceName);
	}
	
	public boolean overallDiscount(int id)
	{
		return dataControl.OverallDiscountCheck(id);
	}
	
}
