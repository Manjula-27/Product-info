package com.product.Entity;

import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.springframework.util.StringUtils;

public class ProductGenerator extends SequenceStyleGenerator  {
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		
		if (object instanceof ProductInfo) {
			ProductInfo p = (ProductInfo)object;
	         if (!StringUtils.isEmpty(p.getCategory()) && p.getCategory() != null && p.getBrand() !=null && !StringUtils.isEmpty(p.getBrand())) {
	        	 String category =String.valueOf(p.getCategory().charAt(0));
	        	 String brand =String.valueOf(p.getBrand().charAt(0));
	        	 Random rand = new Random();
	        	 int n = rand. nextInt((int) Math. pow(10, 10));
	        	 String number = String. format("%010d", n);
	        
	        	String productId = category+ brand+ "-" + number; 
	            return productId;
	         }
	      }
		return super.generate(session, object);
	}

}
