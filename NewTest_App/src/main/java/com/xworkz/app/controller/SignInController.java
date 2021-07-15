package com.xworkz.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;
import com.xworkz.app.dto.SignInDTO;
import com.xworkz.app.dto.SignUpDTO;
import com.xworkz.app.service.SignInService;

@Component
@RequestMapping("/")
public class SignInController {
	
	@Autowired
	private SignInService signInService;
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public ModelAndView login(SignInDTO signInDTO,HttpServletRequest request) {
		
		SignUpDTO dataFromDB =signInService.loginService(signInDTO);
		
		System.out.println("DATA from database:" + dataFromDB);
		if(dataFromDB!=null) {
			HttpSession httpSession=request.getSession(true);
			httpSession.setAttribute("signup_info", dataFromDB);
			return new ModelAndView("Home","msg1", "user signing successfully");
		}
		else {
			return new ModelAndView("Home","msg1", "user Not signing successfully");
		}
	}


	
	

}
