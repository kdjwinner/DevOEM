package com.ktf.oem.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	@RequestMapping(value="/loginCheck", method = RequestMethod.GET)
	public String loginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bol_chk = "false";
		
		return null;
	}	
	
	@RequestMapping(value="/auth", method = RequestMethod.GET)
	public String loginAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bol_chk = "false";
		
		return null;
	}		
	
}
