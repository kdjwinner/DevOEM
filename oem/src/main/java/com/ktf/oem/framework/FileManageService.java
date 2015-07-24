package com.ktf.oem.framework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service("fileManageService")
public class FileManageService {
	
	public String stringFileWrite(String text, String fileName){
		String result = "0";
		try {
		      ////////////////////////////////////////////////////////////////
		      BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false)); 
		      String s = text;
		      writer.write(s);
		      writer.close();
		      ////////////////////////////////////////////////////////////////
		    } catch (Exception e) {
		    	LogHelper.error(this, e.getMessage());
		    	result = "1";
		    }
		return result;
	}
	
	public String fileReadString(String vfile){
		
        // 버퍼 생성
        BufferedReader br = null;        
         
        // Input 스트림 생성
        InputStreamReader isr = null;    
         
        // File Input 스트림 생성
        FileInputStream fis = null;        
 
        // File 경로
        File file = new File(vfile);
 
        // 버퍼로 읽어들일 임시 변수
        String temp = "";
         
        // 최종 내용 출력을 위한 변수
        String content = "";
         		
		
	     try {
             
	            // 파일을 읽어들여 File Input 스트림 객체 생성
	            fis = new FileInputStream(file);
	             
	            // File Input 스트림 객체를 이용해 Input 스트림 객체를 생서하는데 인코딩을 UTF-8로 지정
	            isr = new InputStreamReader(fis, "euc-kr");
	             
	            // Input 스트림 객체를 이용하여 버퍼를 생성
	            br = new BufferedReader(isr);
	         
	            // 버퍼를 한줄한줄 읽어들여 내용 추출
	            while( (temp = br.readLine()) != null) {
	                content += temp + "\n";
	            }
	             
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	             
	        } finally {
	 
	            try {
	                fis.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	             
	            try {
	                isr.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	             
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	             
	        }
	     return content;
	}	
	
}
