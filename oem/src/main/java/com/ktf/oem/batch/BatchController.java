package com.ktf.oem.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/batch")
public class BatchController {
	
	@Autowired	
	private BatchService batchService;
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public void getMainList() throws Exception{
		batchService.getMainListBatch();
	}
}
