package com.ktf.oem.event;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktf.oem.extern.KhubService;
import com.ktf.oem.ktf.KtfCryptoService;

@Service("eventService")
public class EventService {
	
	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private KhubService khubService;	
	
	@Autowired
	private KtfCryptoService ktfCryptoService;	
	
	/*getTopBanner 리스트*/
	public Map<String, String> smsProcess(EventBean eventBean) throws Exception {
		
		/*MMS 전송 결과 map(bean으로 처리시 번호 노출 등으로 꼬투리 잡을까봐 결과만 map으로 처리*/
		Map<String, String> map = new HashMap<String, String>();		
		
		/*시도 log Start*/
		eventBean.setPage_url("smsProcess.jsp");
		eventBean.setPage_param("3");
		eventBean.setReserved1("0");
		eventBean.setReserved2("try");	
		String cur_date = getCurDate();		
		eventBean.setReserved3(cur_date);
		/*db log insert error는 무조건 될거라 판단하고 처리 하지 않았음*/		
		int sms_result = insertSmsLog(eventBean);
		/*시도 log End*/
		
		/*random key insert*/
		String randomString = "";		
		java.util.Random a = new java.util.Random();
		int randomNumber=(int)(Math.random()*100000)+100000; //1000000 이건 자릿수			
		randomString = Integer.toString(randomNumber); 		
		eventBean.setCtn(eventBean.getMdn());
		eventBean.setCertinum(randomString);
		eventBean.setId("OEM");
		
		int random_insert = eventDao.setCertify(eventBean);		
		
		/*random key insert*/
		cur_date = getCurDate();			
		eventBean.setReserved3(cur_date);		
		if(random_insert == 1 ){
			String msg = "[올레링투유(본인인증)]<BR>인증번호는 ["+randomString+"] 입니다.";
			String khub_result = khubService.mmsSend(eventBean.getMdn(), eventBean.getMdn(), msg);
			
			if(khub_result.indexOf("RT1:0")>-1){		
				eventBean.setReserved1("1");
				eventBean.setReserved2("success");
				insertSmsLog(eventBean);
				map.put("smsresult", "success");				
			}else{
				eventBean.setReserved1("2");
				eventBean.setReserved2("connection");
				map.put("smsresult", "error");				
			}			
		}else{
			eventBean.setReserved1("2");
			eventBean.setReserved2("dbinsert");
			map.put("smsresult", "error");					
		}
		
		/*MMS 전송 소스*/		
		
		return map;		
	}
	
	public int insertSmsLog(EventBean eventBean) throws Exception {		
		int num =  eventDao.insertSmsLog(eventBean);
		return num;
	}		
	
	public String getCurDate(){
		String cur_date = "";
		cur_date 		= new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		return cur_date;
	}

	public int getCertify(Map<String, String> map){
		String certiNum			= "";
		int result				= 0;
		String input_certinum 	= map.get("certinum");
		certiNum 				= eventDao.getCertify(map);
		EventUser4 eventUser4   = new EventUser4();
		String cur_date			= getCurDate();
		eventUser4.setRegdate(cur_date);
		eventUser4.setMin(map.get("ctn"));		
		if(input_certinum.equals(certiNum)){
			result = 1;
			eventUser4.setName("OEM 성공");			
			int num = eventDao.insertCertifyResult(eventUser4);
		}else{
			result = 0;
			eventUser4.setName("OEM 실패");			
			int num = eventDao.insertCertifyResult(eventUser4);			
		}
		return result;
	}

}
