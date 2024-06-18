package com.product.Entity;

import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class ShopperIdGenerator extends SequenceStyleGenerator  {
	
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		
		if (object instanceof ShopperInfo) {
			ShopperInfo s = (ShopperInfo)object;
			String prefix ="S";
	         if (s !=null) {
	        	
	        	 Random rand = new Random();
	        	 int n = rand. nextInt((int) Math. pow(10, 4));
	        	 String number = String. format("%010d", n);
	        
	        	String shopperID = prefix + "-" + number; 
	            return shopperID;
	         }
	      }
		return super.generate(session, object);

	}
	
}
