package com.ktf.oem.data;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktf.oem.extern.KtMusicService;
import com.ktf.oem.framework.CharacterService;
import com.ktf.oem.framework.FileManageService;
import com.ktf.oem.framework.HttpConnectionHelper;
import com.ktf.oem.framework.XmlConvertService;

@Service("dataService")
public class DataService {
	
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
	
	@Autowired	
	private FileManageService fileManageService;	
	
	public TbFileMetaInfo getRingCodeList(TbFileMetaInfo tbFileMetaInfo) throws Exception {
		return dataDao.getRingCodeList(tbFileMetaInfo);
	}
	
	public String getMainList() throws Exception {		
		String json = "";
		json = fileManageService.fileReadString("D:\\oem\\file\\web\\mainList.json");
		return json;
	}	
	public String getImageAjax(HashMap<String, String> map) throws Exception {		
		String image 	= "";
		String ktf_lid	= dataDao.getKtfLid(map);
		image			= ktMusicService.getAlbumImageLid(ktf_lid);
		return image;
	}	
	
	public XringInfo getRecommandSongList(TbFileServiceMap2 tbFileServiceMap2) throws Exception {		
		TbFileServiceMap2 returnMap = dataDao.getTbFileServiceMap(tbFileServiceMap2);
		
		XringInfo		  xringInfo = new XringInfo();
		xringInfo.setLid(returnMap.getKtf_lid());		
		String image_url = ktMusicService.getAlbumImageLid(String.valueOf(xringInfo.getLid()));
		xringInfo.setAlbum(image_url);		
		xringInfo.setTitle(returnMap.getFile_title());
		xringInfo.setSinger(returnMap.getFile_singer());
	
		TbFileMetaInfo tbFileMetaInfo = new TbFileMetaInfo();
		tbFileMetaInfo.setScp_id(2044);
		tbFileMetaInfo.setKtf_lid(xringInfo.getLid());		
		tbFileMetaInfo = getRingCodeList(tbFileMetaInfo);		
		
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
		
		return xringInfo;
	}		

	
}
