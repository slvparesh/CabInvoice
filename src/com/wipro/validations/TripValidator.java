package com.wipro.validations;

import java.util.Random;

import com.wipro.bean.CabBean;
import com.wipro.userexceptions.NegativeKilometerException;

public class TripValidator {

	
	public static String printBillAmount(CabBean cabbean)
	{ String status="valid",result="";
	int count=0,km=0;
		String s=cabbean.getBookingID();
		if(s.startsWith("AD")){
			for(int i=2;i<=6;i++){
				if(Character.isDigit(s.charAt(i))){
					count++;
					
				}}
				if(count==5)
					status="valid";
				
				else
					status="Invalid Booking ID";
				
			}
		int u=cabbean.getUserID();
		if(u>0){
			if(u>=1001 && u<=1500)
				status="valid";
			
			else
				status="Invalid User ID";
		}
		String cabtype =cabbean.getCabType();
		if(cabtype.equalsIgnoreCase("Tata Indica")||cabtype.equals("Tata Indigo")|| cabtype.equals("BMU")||cabtype.equalsIgnoreCase("Logan"))
			status="valid";	
		else
			status="Invalid Cab Type";
		try{
		 km=Integer.parseInt(cabbean.getKmsUsed());
		
			if(km<0)
			{
				throw new NegativeKilometerException();
			}
		}
		catch(NegativeKilometerException ex){
			status=ex.toString();
		}
		if(status.equals("valid"))	{
			
			int amountgen[]=new int[2];
			amountgen=amountGenerator(km, cabtype);
			result="total amount "+amountgen[1]+"Receipt id "+amountgen[0];
		}
		else
			result=status;
		
			return result;
	}
		
	
	
	
	public static int[] amountGenerator(int kmsUsed, String
			cabType)
	{
		int array[]=new int[2];
		Random r=new Random();
		int x=r.nextInt(100000);
		while(x<10000){
			x=r.nextInt(100000);
		}
		array[0]=x;
		
		if(cabType.equalsIgnoreCase("Tata Indica")){
			array[1]=kmsUsed*12;
		}
		if(cabType.equalsIgnoreCase("Tata Indigo")){
			array[1]=kmsUsed*10;
		}
		if(cabType.equalsIgnoreCase("BMU")){
			array[1]=kmsUsed*45;
		}
		if(cabType.equalsIgnoreCase("Logan")){
			array[1]=kmsUsed*31;
		}
		return array;
		
	}
	
}
