package com.xworkz.app.util;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomGeneratorPassword {
	
	
	String capLetters= "QWERTYUIOPASDFGHJKLZXCVBNM";
	String smalLetters= "qwertyuiopasdfghjklzxcvbnm";
	String numbers="1234567890";
	String specialLetters="!@#$%^&*";
	
	public RandomGeneratorPassword() {
		System.out.println("Object created in "+this.getClass().getSimpleName());
	}
	

	public String randomGeneratorPassword() {
		System.out.println("In randomGeneratorPassword");
		StringBuilder builder=new StringBuilder();
		builder.append(RandomStringUtils.random(2,capLetters)).append(RandomStringUtils.random(2,smalLetters)).append(RandomStringUtils.random(2,specialLetters));
		
		return new String(builder);
		
	}
	
}
