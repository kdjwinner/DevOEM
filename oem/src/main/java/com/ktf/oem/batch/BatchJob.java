package com.ktf.oem.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJob{

	@Autowired
	private BatchService batchService;	

	/*********************************�Ϲ�ġ ���� ***********************************************************/
	 /** �ϰ� �캰 ���ڸ� DATA 
	  * ���� 6�� 52�� 0�� ���� ������  **/
	@Scheduled(cron = "0 22 18 * * ?")
	public void dailBatch() {
		try {
			batchService.getMainListBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	/*********************************�Ϲ�ġ End ***********************************************************/	
}

