package com.wipro.service;

	import com.wipro.bean.CabBean;
	import com.wipro.validations.TripValidator;
	public class MainClass
	{
	public static void main(String[] args)
	{
	CabBean cabbean = new CabBean();
	cabbean.setBookingID("AD12345");
	cabbean.setCabType("BMU");
	cabbean.setKmsUsed("120");
	cabbean.setUserID(1003);
	cabbean.setUsername("Hariprasath");
	String result =TripValidator.printBillAmount(cabbean);
	System.out.println(result);
	}
	
}
