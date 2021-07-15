package com.xworkz.app.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.app.dto.SignInDTO;
import com.xworkz.app.dto.SignUpDTO;

@Component
public class SignInDAO {

	@Autowired
	private SessionFactory factory;

	
	public SignUpDTO loginDAO(SignInDTO signInDTO) {
		System.out.println("Data from user:"+signInDTO);
		String hql="from SignUpDTO user where user.emailId=:em and user.password=:pass";
		
		Session session=factory.openSession();
		
		Query query=session.createQuery(hql);
		
		String email=signInDTO.getEmailId();
		
		String password = signInDTO.getPassword();
		
		query.setParameter("em", email);
		query.setParameter("pass", password);
		
		SignUpDTO dataFromDB =(SignUpDTO) query.uniqueResult();
		
		return dataFromDB;

		
	}

}
