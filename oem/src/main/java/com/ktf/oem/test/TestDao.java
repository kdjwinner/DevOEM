package com.ktf.oem.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ktf.oem.contents.Content;
import com.ktf.oem.framework.BaseDao;

@Repository("testDao")
public class TestDao extends BaseDao{

	public String oracleGetTest() {
		return sqlSessionOracle.selectOne("test.getTest");
	}
	
	public TestBean2 getJsonTest() {
		TestBean2 testBeanList = new TestBean2();
		List<TestBean2> testbean = new ArrayList();
		testbean = sqlSessionOracle.selectList("test.getJsonTest"); 
		testBeanList.setTestBean2List(testbean); 
		return testBeanList;
	}	
	
	public String mssqlGetTest() {
		return sqlSessionMssql.selectOne("mssql.getTest");
	}	

	public List<TestBean2> getJsonTest2() {
		List<TestBean2> testbean = sqlSessionOracle.selectList("test.getJsonTest"); 
		return testbean;
	}	
	
	public List<TestBean3> getJsonTest3() {
		List<TestBean3> testbean = sqlSessionOracle.selectList("test.getJsonTest2"); 
		return testbean;
	}		
		
	public List getJsonTest4() {
		List testbean = sqlSessionOracle.selectList("test.getJsonTest2"); 
		return testbean;
	}	
	
	public TestBean2 getXmlTest() {
		TestBean2 testbean = sqlSessionOracle.selectOne("test.getXmlTest"); 
		return testbean;
	}		
	
	public List<Content> testBean(Content content) {
		return sqlSessionOracle.selectList("test.testBean", content);
	}	
	
}
