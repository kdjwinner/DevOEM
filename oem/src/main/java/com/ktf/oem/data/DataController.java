package com.ktf.oem.data;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ktf.oem.framework.BaseController;
import com.ktf.oem.framework.ParameterUtil;


@Controller
@RequestMapping("/data")
public class DataController extends BaseController{	
	
	@Autowired
	private DataService	dataService;		
	
	@Autowired
	private ParameterUtil	parameterUtil;		

	@RequestMapping(value="/main/getMainList", method = RequestMethod.POST)
	public void getMainList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String result = dataService.getMainList();		
		JSONObject jsonObject = JSONObject.fromObject(result);		
		MainListBean mainListBean = (MainListBean) JSONObject.toBean(jsonObject, MainListBean.class);		
		this.outputJSON(request,response, mainListBean);
	}	
	@RequestMapping(value="/getImageAjax", method = RequestMethod.POST)
	public void getImageAjax(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HashMap<String, String> param 		= parameterUtil.getAllParameters(request);
		String result 						= dataService.getImageAjax(param);		
		this.outputJSON(request,response, result);
	}		
	
	@RequestMapping(value="/main/getRecommandSongList", method = RequestMethod.POST)
	public void getRecommandSongList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// JsonType formData
		TbFileServiceMap2 tbFileServiceMap2 = new TbFileServiceMap2();
		
		XringInfo new_song	=	new XringInfo();
		XringInfo best_song	=	new XringInfo();
		XringInfo week_song	=	new XringInfo();
		
	    java.util.Random oRandom = new java.util.Random();
		int ran_file_sort = oRandom.nextInt(5)+1;
		tbFileServiceMap2.setFile_sort(ran_file_sort);
		
		tbFileServiceMap2.setCate_code(5444);
		new_song = dataService.getRecommandSongList(tbFileServiceMap2);
		
		tbFileServiceMap2.setCate_code(5445);
		best_song = dataService.getRecommandSongList(tbFileServiceMap2);
		
		tbFileServiceMap2.setCate_code(5446);
		week_song = dataService.getRecommandSongList(tbFileServiceMap2);
		
		
		RecommandSongBean recommandSongBean = new RecommandSongBean();
		
		recommandSongBean.setBest_song(best_song);
		recommandSongBean.setNew_song(new_song);
		recommandSongBean.setWeek_song(week_song);
		
		this.outputJSON(request, response, recommandSongBean);		
	}	
	
	
}
