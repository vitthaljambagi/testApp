package com.xworkz.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.xworkz.app.dao.SignUpDAO;
import com.xworkz.app.dto.SignUpDTO;
import com.xworkz.app.util.RandomGeneratorPassword;

@Component
public class SignUpService {
	
	
	@Autowired
	private SignUpDAO signUpDAO;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private RandomGeneratorPassword randomGeneratorPassword;
	
	public String sendMail(String to, String subject, String text,String password) {
		System.out.println(" TO "+to+" subject "+subject+ " text is " +text);
		System.out.println("sending mail");
		
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);
		
		mailSender.send(mailMessage);
		
		return "Mail sent to:\t "+to;
		
	}
	
	public SignUpDTO signUpServiceImpl(SignUpDTO signUpDTO) {
		
		String password =randomGeneratorPassword.randomGeneratorPassword();
		
		signUpDAO.signUpDAO(signUpDTO,password);
		
		String emailID=signUpDTO.getEmailId();
		
		System.out.println("email from DB "+emailID);
	
		SimpleMailMessage simpleMessage = new SimpleMailMessage();

		simpleMessage.setTo(emailID);
	
		
		System.out.println("Password is from random generator "+password);
		
		String subject ="Confimation Mail From Jambagi";
		String text = "Your account is created \n" +
				  	  "Please login by using below \n" + "Email:\n" + emailID+ "\n"+
				  	  "Password:\n"+password;
		
		sendMail(emailID, subject, text,password);
		
		return signUpDTO;
		
	}

}
