package com.ktf.oem.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ViewController {
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/main";			
	}	

	@RequestMapping(value="/myring/myring", method = RequestMethod.GET)
	public String myring(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/myring/myring";			
	}	
	
	@RequestMapping(value="/help/notice", method = RequestMethod.GET)
	public String notice(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/help/notice";			
	}	
	
	@RequestMapping(value="/help/info", method = RequestMethod.GET)
	public String info(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/help/info";			
	}	
	
	@RequestMapping(value="/help/termsOfUse", method = RequestMethod.GET)
	public String termsOfUse(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/help/termsOfUse";			
	}	
	
	@RequestMapping(value="/help/termsOfUser", method = RequestMethod.GET)
	public String termsOfUser(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/help/termsOfUser";			
	}	
		
}
