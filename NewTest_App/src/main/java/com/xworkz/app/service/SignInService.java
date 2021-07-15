package com.xworkz.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.app.dao.SignInDAO;
import com.xworkz.app.dto.SignInDTO;
import com.xworkz.app.dto.SignUpDTO;

@Component
public class SignInService {

	@Autowired
	private SignInDAO signInDAO;
	
	public SignUpDTO loginService(SignInDTO signInDTO) {

		SignUpDTO dataFromDB= signInDAO.loginDAO(signInDTO);
		return dataFromDB;
		
	}

}
