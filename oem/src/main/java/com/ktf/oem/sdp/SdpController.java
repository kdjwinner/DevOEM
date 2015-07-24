package com.ktf.oem.sdp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ktf.oem.data.MainListBean;
import com.ktf.oem.framework.BaseController;

@Controller
@RequestMapping("/sdp")
public class SdpController extends BaseController{	
	
	@RequestMapping(value="/oif553", method = RequestMethod.POST)
	public void getMainList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		this.outputJSON(request,response, null);
	}		
	
}
