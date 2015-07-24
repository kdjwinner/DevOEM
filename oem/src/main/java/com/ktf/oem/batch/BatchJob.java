package com.ktf.oem.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJob{

	@Autowired
	private BatchService batchService;	

	/*********************************일배치 시작 ***********************************************************/
	 /** 일간 띠별 별자리 DATA 
	  * 매일 6시 52분 0초 익일 데이터  **/
	@Scheduled(cron = "0 22 18 * * ?")
	public void dailBatch() {
		try {
			batchService.getMainListBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	/*********************************일배치 End ***********************************************************/	
}

