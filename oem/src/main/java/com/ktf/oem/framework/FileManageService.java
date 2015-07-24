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
		
        // ���� ����
        BufferedReader br = null;        
         
        // Input ��Ʈ�� ����
        InputStreamReader isr = null;    
         
        // File Input ��Ʈ�� ����
        FileInputStream fis = null;        
 
        // File ���
        File file = new File(vfile);
 
        // ���۷� �о���� �ӽ� ����
        String temp = "";
         
        // ���� ���� ����� ���� ����
        String content = "";
         		
		
	     try {
             
	            // ������ �о�鿩 File Input ��Ʈ�� ��ü ����
	            fis = new FileInputStream(file);
	             
	            // File Input ��Ʈ�� ��ü�� �̿��� Input ��Ʈ�� ��ü�� �����ϴµ� ���ڵ��� UTF-8�� ����
	            isr = new InputStreamReader(fis, "euc-kr");
	             
	            // Input ��Ʈ�� ��ü�� �̿��Ͽ� ���۸� ����
	            br = new BufferedReader(isr);
	         
	            // ���۸� �������� �о�鿩 ���� ����
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
