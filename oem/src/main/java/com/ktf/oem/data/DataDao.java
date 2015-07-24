package com.ktf.oem.data;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.ktf.oem.framework.BaseDao;


@Repository("dataDao")
public class DataDao extends BaseDao{
	public TbFileMetaInfo getRingCodeList(TbFileMetaInfo tbFileMetaInfo) {
		return sqlSessionOracle.selectOne("data.getRingCodeList", tbFileMetaInfo); 
	}	
	public TbFileServiceMap2 getTbFileServiceMap(TbFileServiceMap2 tbFileServiceMap2) {
		return (TbFileServiceMap2) sqlSessionOracle.selectOne("data.getTbFileServiceMap", tbFileServiceMap2); 
	}	
	public String getKtfLid(HashMap<String, String> map) {
		return sqlSessionOracle.selectOne("data.getKtfLid", map);
	}		
	
}
