package com.ktf.oem.framework;

import org.springframework.stereotype.Service;

@Service("charService")
public class CharacterService {
	//Ư������ ���� ��� 
	public String replaceChar(String targetStr){
		String returnStr = targetStr;  
		try{ 
			returnStr = returnStr.replaceAll("\"", "&quot");
			returnStr = returnStr.replaceAll("&", "&amp");
			returnStr = returnStr.replaceAll("<", "[");
			returnStr = returnStr.replaceAll(">", "]");
			returnStr = returnStr.replaceAll("%", "��");
			returnStr = returnStr.replaceAll("#", " ");
			returnStr = returnStr.replaceAll("@", " ");
		}catch(Exception e){} 

		return returnStr;
	}	
}
