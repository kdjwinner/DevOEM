package com.ktf.oem.framework;

import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("parameterUtil")
public class ParameterUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ParameterUtil.class);
	
	public HashMap<String, String> getAllParameters(HttpServletRequest request) {
		HashMap<String, String> param = new HashMap<String, String>();
		Enumeration requestParameters = request.getParameterNames();
	    while (requestParameters.hasMoreElements()) {
	        String element = (String) requestParameters.nextElement();
	        String value = request.getParameter(element);
	        if (element != null && value != null) {
	        	param.put(element, value);
	            logger.info("param Name : " + element  + ", value : " + value);
	        }
	    }
	    return param;
	}
}
