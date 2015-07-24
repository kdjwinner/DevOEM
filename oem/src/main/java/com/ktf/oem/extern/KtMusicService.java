package com.ktf.oem.extern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktf.oem.framework.HttpConnectionHelper;

@Service("ktMusicService")
public class KtMusicService {

	@Autowired
	private HttpConnectionHelper httpConnectionHelper;
	
	public String getAlbumImageLid(String lid){
		String album_image = "";
		String tmp_album_image = "";
		String imageGetURL = "http://searchapi.ollehmusic.com:9980/engine/image?lid=" + lid;		
		tmp_album_image = httpConnectionHelper.requestGet(imageGetURL);
		if(tmp_album_image.equals("error") || tmp_album_image.equals("")){
			album_image = "images/no_image.gif";			
		}else if(tmp_album_image.indexOf("img")<1){
			album_image = "images/no_image.gif";			
		}else{
			album_image = "http://image.ollehmusic.com/";
			album_image += tmp_album_image.substring(tmp_album_image.indexOf("img") + 6, tmp_album_image.indexOf("\"}"));			
		}		
		return album_image;
	}	
	
	
}
