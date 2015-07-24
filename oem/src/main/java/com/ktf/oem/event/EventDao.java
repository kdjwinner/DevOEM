package com.ktf.oem.event;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ktf.oem.framework.BaseDao;

@Repository("eventDao")
public class EventDao extends BaseDao{
	
	public int insertSmsLog(EventBean eventBean) {
		return sqlSessionOracle.insert("event.insertSmsLog", eventBean);
	}
	
	public int setCertify(EventBean eventBean) {
		return sqlSessionOracle.insert("event.setCertify", eventBean);
	}
	public String getCertify(Map<String, String> map) {
		return sqlSessionOracle.selectOne("event.getCertify", map);
	}
	public int insertCertifyResult(EventUser4 eventUser4) {
		return sqlSessionOracle.insert("event.insertCertifyResult", eventUser4);
	}	
}
