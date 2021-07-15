package com.xworkz.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.app.dto.SignUpDTO;
import com.xworkz.app.service.SignUpService;

@Component
@RequestMapping("/")
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService; 
	
	public SignUpController() {

		System.out.println("Object created in "+this.getClass().getSimpleName());
	}

	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView signUpController(SignUpDTO signUpDTO) {
		System.out.println("In signup");
		signUpService.signUpServiceImpl(signUpDTO);
		return new ModelAndView("signin", "msg", "User Created Successfully");
		
	}
}
