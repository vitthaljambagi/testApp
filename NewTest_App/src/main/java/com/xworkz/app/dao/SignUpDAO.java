package com.xworkz.app.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.app.dto.SignUpDTO;

@Component
@Transactional
public class SignUpDAO {

	@Autowired
	private SessionFactory factory;

	public SignUpDTO signUpDAO(SignUpDTO signUpDTO,String password) {

		System.out.println("password in DAo "+password);
	//	Session session = factory.openSession();
		//Transaction transaction = session.beginTransaction();
	//	session.save(signUpDTO);
		System.out.println("data saved into DB ");
		

		Session session1 = factory.openSession();
		Transaction transaction1 = session1.beginTransaction();
		session1.save(signUpDTO);
		
		Query query1 = session1.createQuery("update SignUpDTO set password=:pass where ID=:id");

		
		System.out.println("data update into DB 1111");
		
	//	String password = signUpDTO.getPassword();

		int ids=signUpDTO.getId();
		
		query1.setParameter("id", ids);
		query1.setParameter("pass", password);

		int status=query1.executeUpdate(); 
		System.out.println("data update into DB ");
		System.out.println("status is "+status);
		
		transaction1.commit();
		
		
		return signUpDTO;
	}

}
