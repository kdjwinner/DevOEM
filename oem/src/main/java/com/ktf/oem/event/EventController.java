package com.ktf.oem.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.CookieGenerator;

import com.ktf.oem.framework.BaseController;
import com.ktf.oem.framework.CookieService;
import com.ktf.oem.framework.ParameterUtil;
import com.ktf.oem.ktf.KtfCryptoService;

@Controller
@RequestMapping("/event")
public class EventController extends BaseController{	

	@Autowired
	private EventService	eventService;	
	
	@Autowired
	private ParameterUtil	parameterUtil;		
	
	@Autowired
	private KtfCryptoService ktfCryptoService;
	
	@Autowired
	private CookieService cookieService;
	
	
	
	@RequestMapping(value="/sendSMS", method = RequestMethod.GET)
	public String sendSMS(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/event/sendSMS";			
	}		
	
	@RequestMapping(value="/smsProcess", method = RequestMethod.POST)
	public void smsProcess(HttpServletRequest request, HttpServletResponse response) throws Exception{
		EventBean eventBean = (EventBean) getObjectFromJSON(request, EventBean.class);
		String conn_ip = request.getRemoteAddr();		
		eventBean.setConn_ip(conn_ip);	
		this.outputJSON(request,response, eventService.smsProcess(eventBean));
	}	
	
	@RequestMapping(value="/smsCheck", method = RequestMethod.POST)
	public String smsCheck(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		HashMap<String, String> param 		= parameterUtil.getAllParameters(request);
		int result							= eventService.getCertify(param);
		int cookie_result					= 1;
		Map<String, String> loginMap 	= new HashMap<String, String>(); 
		if(result >0){
			
			loginMap 		= ktfCryptoService.ktEncryptoMap(param.get("ctn"), 4);		
			cookie_result 	= cookieService.setCookieMap(response, loginMap, 60*60*2, "/");
			if(cookie_result > 0){
				model.addAttribute("msg", "인증이 완료되었습니다.");			
				model.addAttribute("url", "/");					
			}else{
				model.addAttribute("msg", "서비스가 지연중입니다. 잠시 후 다시 시도해 주세요");			
				model.addAttribute("url", "/event/sendSMS");							
			}
		}else{
			model.addAttribute("msg", "인증번호가 올바르지 않습니다.");			
			model.addAttribute("url", "/event/sendSMS");
		}
		return "/redirect";
	}		
	
	@RequestMapping(value="/delCookie", method = RequestMethod.GET)
	public String delCookie(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {	
		//int cookie_result	=	cookieService.delCookie(request, response);	

	    Cookie[] cookies = request.getCookies() ;
	    if(cookies != null){
	        for(int i=0; i < cookies.length; i++){	    
	        	System.out.println(cookies[i].getName());
	        	System.out.println(cookies[i].getPath());
	    		CookieGenerator cookieGer = new CookieGenerator();     
	    		cookieGer.setCookiePath("/");	    		
	    		cookieGer.setCookieName(cookies[i].getName());
	    		cookieGer.setCookieMaxAge(0);	
	    		cookieGer.addCookie(response, "");	    		
	        }
	    }		
		model.addAttribute("msg", "서비스가 해제 되었습니다.");			
		model.addAttribute("url", "/");
		return "/redirect";		
	}		

	
}
