package com.ktf.oem.test;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktf.oem.contents.Content;
import com.ktf.oem.framework.FileManageService;
import com.ktf.oem.framework.LogHelper;
import com.ktf.oem.framework.XmlConvertService;
import com.thoughtworks.xstream.XStream;


@Service("testService")
public class TestService {
	/*
	@Autowired
	private TestDao testDao;	

	public String getTest() throws Exception {
		String test = "";
		test = 	testDao.getTest();
		return test;
	}
	*/	
	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private FileManageService fileManageService;		

	@Autowired
	private XmlConvertService xmlConvertService;
	
	public String oracleGetTest() throws Exception {
		String oracle = "";
		oracle = 	testDao.oracleGetTest();
		return oracle;
	}
	
	public String mssqlGetTest() throws Exception {
		String mssql = "";
		mssql = 	testDao.mssqlGetTest();
		return mssql;
	}
	
	public String getJsonTest() throws Exception {		
		String json = "";
		TestBean2 jsonList 		= testDao.getJsonTest();
		JSONObject jsonObj =    JSONObject.fromObject(jsonList);
		
		return json;
	}	
	
	public String getJsonTest2() throws Exception {		
		String json = "";
		List<TestBean2> jsonList 		= testDao.getJsonTest2();		
		List  test =  JSONArray.fromObject(jsonList);
		
		return json;
	}		
	
	public String getJsonTest3() throws Exception {		
		String json = "";
		List jsonList 		= testDao.getJsonTest3();		
		json =  JSONArray.fromObject(jsonList).toString();		
		return json;
	}			
	
	public String getJsonTest4() throws Exception {		
		String json = "";
		List jsonList 		= testDao.getJsonTest4();		
		json =  JSONArray.fromObject(jsonList).toString();		
		String result = fileManageService.stringFileWrite(json, "D:\\ringbell\\file\\web\\r20000.json");
		return result;
	}		
	
	public String getXmlTest() throws Exception {		
		String xml = "";
//		TestBean2 testbean2 = testDao.getXmlTest();
		TestBean2 testbean2 = new TestBean2();
		testbean2.setTitle("test");
		testbean2.setFile("testfile");
		testbean2.setCate_code("testcode");
		XStream xstream = new XStream();
		xstream.alias("testbean2", TestBean2.class);
		xml = xstream.toXML(testbean2);
		return xml;
	}			
	
	public String getXmlTest2() throws Exception {		
		String xml = "";
		TestBean2 testbean2 = new TestBean2();
		testbean2.setTitle("test");
		testbean2.setFile("testfile");
		testbean2.setCate_code("testcode");
		xml = xmlConvertService.objectToString(testbean2, "testbean2");
		return xml;
	}
	
	public void xmlTobean(String xml) throws Exception {		
		TestBean2 testbean = new TestBean2();
		testbean = (TestBean2)xmlConvertService.xmlToClass(testbean, xml, "testbean2");	
		LogHelper.debug(this.getClass(), "test");
	}	
	
	public String getRecommand() throws Exception {		
		String json = "";
		json = fileManageService.fileReadString("D:\\ringbell\\file\\web\\r20000.json");
		return json;
	}	
	
	/**getCounselList**/
	public Content testBean(Content content) throws Exception {
		List<Content> list 	= testDao.testBean(content);	
		content.setContentList(list);
		return content;
	}	
	
}
