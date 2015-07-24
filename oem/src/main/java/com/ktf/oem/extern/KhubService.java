package com.ktf.oem.extern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktf.oem.framework.HttpConnectionHelper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
@Service("khubService")
public class KhubService {
	
	@Autowired
	private HttpConnectionHelper httpConnectionHelper;
	
	public String mmsSend(String rcvctn, String callctn, String msg){
		String result = "";
		String url = "";
		try {
			url = "http://ring.mobile.olleh.com/IIS/khub/mesg_sendmmsrptnnc.asp?rcvctn="+rcvctn+"&callctn="+callctn+"&msg="+URLEncoder.encode(msg, "euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = httpConnectionHelper.requestGet(url);
		return result;
	}
}
