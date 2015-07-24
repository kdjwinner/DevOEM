package com.ktf.oem.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ktf.oem.contents.Content;
import com.ktf.oem.framework.BaseController;
import com.ktf.oem.framework.FileManageService;
import com.ktf.oem.framework.LogHelper;
import com.ktf.oem.ktf.KtfCryptoService;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController{
	
	@Autowired
	private TestService	testService;		
	
	@Autowired
	private KtfCryptoService kyfCryptoService;
	
	@Autowired
	private FileManageService fileManageService;	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		return "main";
	}
	
	@RequestMapping(value="/getTest", method = RequestMethod.GET)
	public void getTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String oracle = testService.oracleGetTest();
		String mssql = testService.mssqlGetTest();	
		
		LogHelper.info(this, "oracle : " + oracle);	
		LogHelper.info(this, "mssql : " + mssql);				
		
	}

	@RequestMapping(value = "/musicTest", method = RequestMethod.GET)
	public String musicTest() {		
		return "musicTest";
	}	
	
	
	@RequestMapping(value = "/decrypt", method = RequestMethod.GET)
	public void decrypt(HttpServletRequest request, HttpServletResponse response ) throws Exception {
		String keyid = request.getParameter("keyid");
		String enckey = request.getParameter("enckey");
		String param = request.getParameter("param");		
		LogHelper.info(this, "keyid : " + keyid);
		LogHelper.info(this, "enckey : " + enckey);
		LogHelper.info(this, "param : " + param);
		
		String test = kyfCryptoService.ktDecrtpyto(keyid, enckey, param);
		LogHelper.info(this, test);
	}		
		
	@RequestMapping(value = "/jsonTest", method = RequestMethod.GET)
	public void jsonTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String test = testService.getJsonTest();
		String a = "";
	}	
	
	@RequestMapping(value = "/jsonTest2", method = RequestMethod.GET)
	public void jsonTest2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String test = testService.getJsonTest2();
		String a = "";
	}		
	
	@RequestMapping(value = "/jsonTest3", method = RequestMethod.GET)
	public void jsonTest3(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String test = testService.getJsonTest3();
		String a = "";
	}			
	
	@RequestMapping(value = "/jsonTest4", method = RequestMethod.GET)
	public void jsonTest4(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = testService.getJsonTest4();
		LogHelper.info(this, result);
	}
	
	@RequestMapping(value = "/xmlTest", method = RequestMethod.GET)
	public void xmlTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = testService.getXmlTest2();
		testService.xmlTobean(result);
		LogHelper.info(this, result);
	}	
	@RequestMapping(value = "/recommand")
	public void recommand(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String result = testService.getRecommand();
		
		this.outputJSON(request,response, result);
	}
	@RequestMapping(value = "/testBean")
	public void getCounselList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// JsonType formDataz
		Content content = (Content) getObjectFromJSON(request, Content.class);
		this.outputJSON(request, response, testService.testBean(content));
	}	
}
