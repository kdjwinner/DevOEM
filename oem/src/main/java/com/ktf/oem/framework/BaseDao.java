package com.ktf.oem.framework;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseDao {
	
	/** oracle DB�� SqlSessionFacotry */
	@Autowired
	@Qualifier("oracleDBFactory")
	protected SqlSessionFactory 	sqlSessionFactioyOracle;		
	
	/** oracle DB�� SqlSession */
	@Autowired
	@Qualifier("oracleDB")
	protected SqlSession		sqlSessionOracle;
	
	/** oracle DB�� SqlSessionFacotry */
	@Autowired
	@Qualifier("mssqlDBFactory")
	protected SqlSessionFactory 	sqlSessionFactioyMssql;		
	
	/** oracle DB�� SqlSession */
	@Autowired
	@Qualifier("mssqlDB")
	protected SqlSession		sqlSessionMssql;	
	
}
