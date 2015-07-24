package com.ktf.oem.framework;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.util.CookieGenerator;

@Service("CookieService")
public class CookieService {
	
	public void setCookie(HttpServletResponse res, String name, String value, int maxAge, String path){

		try {
			name = URLEncoder.encode(name, BaseConstant.DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}		

		CookieGenerator cookieGer = new CookieGenerator();
		cookieGer.setCookiePath(path);
		cookieGer.setCookieName(name);
		cookieGer.setCookieMaxAge(maxAge);
		cookieGer.addCookie(res, value);

	}	
	public int setCookieMap(HttpServletResponse res, Map<String, String> map, int maxAge, String path){
		int result = 1;
		Iterator<String> Ir_keys;	 	
		Iterator<String> Ir_values;	
		
		Collection<String> keys = map.keySet();
	    Ir_keys = keys.iterator();
	    
        Collection<String> values = map.values();
        Ir_values = values.iterator();	    
		
        
	    while (Ir_keys.hasNext() && Ir_values.hasNext()) {
	    	String name 	= "";
	    	String value 	= "";
	    	name			= Ir_keys.next();
	    	value			= Ir_values.next();
			try {
				name = URLEncoder.encode(name, BaseConstant.DEFAULT_ENCODING);
			} catch (UnsupportedEncodingException e) {			
				e.printStackTrace();
				result = 0;
				break;
			}		

			CookieGenerator cookieGer = new CookieGenerator();
			cookieGer.setCookiePath(path);
			cookieGer.setCookieName(name);
			cookieGer.setCookieMaxAge(maxAge);
			cookieGer.addCookie(res, value);

        }	    
	    
	    return result;
	}	
	

}
