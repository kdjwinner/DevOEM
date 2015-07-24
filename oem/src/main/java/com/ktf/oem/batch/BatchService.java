package com.ktf.oem.batch;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktf.oem.data.DataDao;
import com.ktf.oem.data.DataService;
import com.ktf.oem.data.MainListBean;
import com.ktf.oem.data.RING;
import com.ktf.oem.data.RcsList;
import com.ktf.oem.data.TbFileMetaInfo;
import com.ktf.oem.data.XringInfo;
import com.ktf.oem.extern.KtMusicService;
import com.ktf.oem.framework.CharacterService;
import com.ktf.oem.framework.FileManageService;
import com.ktf.oem.framework.HttpConnectionHelper;
import com.ktf.oem.framework.XmlConvertService;
import com.thoughtworks.xstream.XStream;

@Service("batchService")
public class BatchService {
	
	@Autowired	
	private DataService dataService;
	
	@Autowired	
	private FileManageService fileManageService;
	
	@Autowired
	private HttpConnectionHelper httpConnectionHelper;		
	
	@Autowired	
	private XmlConvertService xmlConvertService;
	
	@Autowired	
	private KtMusicService ktMusicService;
	
	@Autowired	
	private CharacterService characterService;	
	
	@Autowired	
	private DataDao dataDao;

	
	public void getMainListBatch() throws Exception{
		MainListBean mainListBean = getMainList();
		String jsonData	= JSONObject.fromObject(mainListBean).toString();
		String fileName = "D:/oem/file/web/mainList.json";
		fileManageService.stringFileWrite(jsonData, fileName);
	}			
	
	public MainListBean getMainList() throws Exception {
		/*
		 * 상용
		String url 			= "http://61.74.66.222/KTMusicDB/MetaMgr/xml_rcs_ring_3.asp?cate_code=new";
		String url2			= "http://61.74.66.222/KTMusicDB/MetaMgr/xml_rcs_ring_3.asp?cate_code=day";	
		String url3			= "http://61.74.66.222/KTMusicDB/MetaMgr/xml_rcs_ring_3.asp?cate_code=best";	
		String result 		= httpConnectionHelper.requestGet(url);
		String result2 		= httpConnectionHelper.requestGet(url2);				
		String result3 		= httpConnectionHelper.requestGet(url3);				
		*상용/
		*
		/*TB*/
		String result		= "";
		String result2		= "";		
		String result3		= "";
		result  = fileManageService.fileReadString("D:\\oem\\file\\web\\tb\\xml_rcs_ring_3_tb.xml");
		result2 = result;
		result3 = result;
	
		/*TB*/
		
		XStream xstream = new XStream();		
		xstream.alias("RING", RING.class);
		xstream.alias("RCS", RcsList.class);
		xstream.addImplicitCollection(RcsList.class, "rcsList");
		
		RcsList rcsLIST 	= (RcsList) xstream.fromXML(result);
		RcsList rcsLIST2 	= (RcsList) xstream.fromXML(result2);
		RcsList rcsLIST3 	= (RcsList) xstream.fromXML(result3);
		
		List<XringInfo> xringInfoList1 = new ArrayList<XringInfo>();
		List<XringInfo> xringInfoList2 = new ArrayList<XringInfo>();		
		List<XringInfo> xringInfoList3 = new ArrayList<XringInfo>();		
		
//		for(int i=0; i<rcsLIST.getRcsList().size(); i++){
		for(int i=0; i<100; i++){		
			String image_url = ktMusicService.getAlbumImageLid(rcsLIST.getRcsList().get(i).getLID());
			XringInfo xringInfo = new XringInfo();
			xringInfo.setAlbum(image_url);
			xringInfo.setLid(Integer.parseInt(rcsLIST.getRcsList().get(i).getLID()));
			xringInfo.setTitle(characterService.replaceChar(rcsLIST.getRcsList().get(i).getSONG()));
			xringInfo.setSinger(characterService.replaceChar(rcsLIST.getRcsList().get(i).getSINGER()));
			TbFileMetaInfo tbFileMetaInfo = new TbFileMetaInfo();
			tbFileMetaInfo.setScp_id(2044);
			tbFileMetaInfo.setKtf_lid(Integer.parseInt(rcsLIST.getRcsList().get(i).getLID()));			
			tbFileMetaInfo = dataService.getRingCodeList(tbFileMetaInfo);
			if(tbFileMetaInfo == null){
				xringInfo.setxRingCode1("");
				xringInfo.setxRingCode2("");
				xringInfo.setxRingCode3("");
				xringInfo.setlRingCode1("");
				xringInfo.setlRingCode2("");
				xringInfo.setlRingCode3("");	
				xringInfo.setJukechk("");	
				xringInfo.setxRingCode("");		
				xringInfo.setR19_LICENCE_TF("");				
			}else{
				xringInfo.setxRingCode1(tbFileMetaInfo.getXring1());
				xringInfo.setxRingCode2(tbFileMetaInfo.getXring2());
				xringInfo.setxRingCode3(tbFileMetaInfo.getXring3());
				xringInfo.setlRingCode1(tbFileMetaInfo.getLring1());
				xringInfo.setlRingCode2(tbFileMetaInfo.getLring2());
				xringInfo.setlRingCode3(tbFileMetaInfo.getLring3());
				xringInfo.setJukechk(characterService.replaceChar(rcsLIST.getRcsList().get(i).getHD()));
				if(xringInfo.getxRingCode1() != null && !("".equals(xringInfo.getxRingCode1()))){
					xringInfo.setxRingCode(xringInfo.getxRingCode1());
				}else if(xringInfo.getxRingCode2() != null && !("".equals(xringInfo.getxRingCode2()))){
					xringInfo.setxRingCode(xringInfo.getxRingCode2());				
				}else if(xringInfo.getxRingCode3() != null && !("".equals(xringInfo.getxRingCode3()))){
					xringInfo.setxRingCode(xringInfo.getxRingCode3());				
				}else if(xringInfo.getlRingCode1() != null && !("".equals(xringInfo.getlRingCode1()))){
					xringInfo.setxRingCode(xringInfo.getlRingCode1());				
				}else if(xringInfo.getlRingCode2() != null && !("".equals(xringInfo.getlRingCode2()))){
					xringInfo.setxRingCode(xringInfo.getlRingCode2());				
				}else if(xringInfo.getlRingCode3() != null && !("".equals(xringInfo.getlRingCode3()))){
					xringInfo.setxRingCode(xringInfo.getlRingCode3());				
				}else{
					xringInfo.setxRingCode("");				
				}
				xringInfo.setR19_LICENCE_TF(tbFileMetaInfo.getR19_licence_tf());				
			}

			xringInfoList1.add(xringInfo);
		}
		
		for(int i=0; i<100; i++){		
			String image_url = ktMusicService.getAlbumImageLid(rcsLIST2.getRcsList().get(i).getLID());
			XringInfo xringInfo = new XringInfo();
			xringInfo.setAlbum(image_url);
			xringInfo.setLid(Integer.parseInt(rcsLIST2.getRcsList().get(i).getLID()));
			xringInfo.setTitle(characterService.replaceChar(rcsLIST2.getRcsList().get(i).getSONG()));
			xringInfo.setSinger(characterService.replaceChar(rcsLIST2.getRcsList().get(i).getSINGER()));
			TbFileMetaInfo tbFileMetaInfo = new TbFileMetaInfo();
			tbFileMetaInfo.setScp_id(2044);
			tbFileMetaInfo.setKtf_lid(Integer.parseInt(rcsLIST2.getRcsList().get(i).getLID()));			
			tbFileMetaInfo = dataService.getRingCodeList(tbFileMetaInfo);
			if(tbFileMetaInfo == null){
				xringInfo.setxRingCode1("");
				xringInfo.setxRingCode2("");
				xringInfo.setxRingCode3("");
				xringInfo.setlRingCode1("");
				xringInfo.setlRingCode2("");
				xringInfo.setlRingCode3("");	
				xringInfo.setJukechk("");	
				xringInfo.setxRingCode("");		
				xringInfo.setR19_LICENCE_TF("");				
			}else{
				xringInfo.setxRingCode1(tbFileMetaInfo.getXring1());
				xringInfo.setxRingCode2(tbFileMetaInfo.getXring2());
				xringInfo.setxRingCode3(tbFileMetaInfo.getXring3());
				xringInfo.setlRingCode1(tbFileMetaInfo.getLring1());
				xringInfo.setlRingCode2(tbFileMetaInfo.getLring2());
				xringInfo.setlRingCode3(tbFileMetaInfo.getLring3());
				xringInfo.setJukechk(characterService.replaceChar(rcsLIST2.getRcsList().get(i).getHD()));
				if(xringInfo.getxRingCode1() != null && !("".equals(xringInfo.getxRingCode1()))){
					xringInfo.setxRingCode(xringInfo.getxRingCode1());
				}else if(xringInfo.getxRingCode2() != null && !("".equals(xringInfo.getxRingCode2()))){
					xringInfo.setxRingCode(xringInfo.getxRingCode2());				
				}else if(xringInfo.getxRingCode3() != null && !("".equals(xringInfo.getxRingCode3()))){
					xringInfo.setxRingCode(xringInfo.getxRingCode3());				
				}else if(xringInfo.getlRingCode1() != null && !("".equals(xringInfo.getlRingCode1()))){
					xringInfo.setxRingCode(xringInfo.getlRingCode1());				
				}else if(xringInfo.getlRingCode2() != null && !("".equals(xringInfo.getlRingCode2()))){
					xringInfo.setxRingCode(xringInfo.getlRingCode2());				
				}else if(xringInfo.getlRingCode3() != null && !("".equals(xringInfo.getlRingCode3()))){
					xringInfo.setxRingCode(xringInfo.getlRingCode3());				
				}else{
					xringInfo.setxRingCode("");				
				}
				xringInfo.setR19_LICENCE_TF(tbFileMetaInfo.getR19_licence_tf());				
			}

			xringInfoList2.add(xringInfo);
		}		
		for(int i=0; i<100; i++){		
			String image_url = ktMusicService.getAlbumImageLid(rcsLIST3.getRcsList().get(i).getLID());
			XringInfo xringInfo = new XringInfo();
			xringInfo.setAlbum(image_url);
			xringInfo.setLid(Integer.parseInt(rcsLIST3.getRcsList().get(i).getLID()));
			xringInfo.setTitle(characterService.replaceChar(rcsLIST3.getRcsList().get(i).getSONG()));
			xringInfo.setSinger(characterService.replaceChar(rcsLIST3.getRcsList().get(i).getSINGER()));
			TbFileMetaInfo tbFileMetaInfo = new TbFileMetaInfo();
			tbFileMetaInfo.setScp_id(2044);
			tbFileMetaInfo.setKtf_lid(Integer.parseInt(rcsLIST3.getRcsList().get(i).getLID()));			
			tbFileMetaInfo = dataService.getRingCodeList(tbFileMetaInfo);
			if(tbFileMetaInfo == null){
				xringInfo.setxRingCode1("");
				xringInfo.setxRingCode2("");
				xringInfo.setxRingCode3("");
				xringInfo.setlRingCode1("");
				xringInfo.setlRingCode2("");
				xringInfo.setlRingCode3("");	
				xringInfo.setJukechk("");	
				xringInfo.setxRingCode("");		
				xringInfo.setR19_LICENCE_TF("");				
			}else{
				xringInfo.setxRingCode1(tbFileMetaInfo.getXring1());
				xringInfo.setxRingCode2(tbFileMetaInfo.getXring2());
				xringInfo.setxRingCode3(tbFileMetaInfo.getXring3());
				xringInfo.setlRingCode1(tbFileMetaInfo.getLring1());
				xringInfo.setlRingCode2(tbFileMetaInfo.getLring2());
				xringInfo.setlRingCode3(tbFileMetaInfo.getLring3());
				xringInfo.setJukechk(characterService.replaceChar(rcsLIST3.getRcsList().get(i).getHD()));
				if(xringInfo.getxRingCode1() != null && !("".equals(xringInfo.getxRingCode1()))){
					xringInfo.setxRingCode(xringInfo.getxRingCode1());
				}else if(xringInfo.getxRingCode2() != null && !("".equals(xringInfo.getxRingCode2()))){
					xringInfo.setxRingCode(xringInfo.getxRingCode2());				
				}else if(xringInfo.getxRingCode3() != null && !("".equals(xringInfo.getxRingCode3()))){
					xringInfo.setxRingCode(xringInfo.getxRingCode3());				
				}else if(xringInfo.getlRingCode1() != null && !("".equals(xringInfo.getlRingCode1()))){
					xringInfo.setxRingCode(xringInfo.getlRingCode1());				
				}else if(xringInfo.getlRingCode2() != null && !("".equals(xringInfo.getlRingCode2()))){
					xringInfo.setxRingCode(xringInfo.getlRingCode2());				
				}else if(xringInfo.getlRingCode3() != null && !("".equals(xringInfo.getlRingCode3()))){
					xringInfo.setxRingCode(xringInfo.getlRingCode3());				
				}else{
					xringInfo.setxRingCode("");				
				}
				xringInfo.setR19_LICENCE_TF(tbFileMetaInfo.getR19_licence_tf());				
			}
			
			xringInfoList3.add(xringInfo);
		}		
		
		
		MainListBean mainListBean = new MainListBean();
		mainListBean.setBestList(xringInfoList1);
		mainListBean.setNewList(xringInfoList2);
		mainListBean.setWeekList(xringInfoList3);
		return mainListBean;
	}		
	
}
