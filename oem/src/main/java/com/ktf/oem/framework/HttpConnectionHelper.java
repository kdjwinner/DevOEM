package com.ktf.oem.framework;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.springframework.stereotype.Service;

@Service("httpConnectionHelper")
public class HttpConnectionHelper {
	private static final int TIMEOUT_LIMIT 	= 1000;
	private static final String ENCODING 	= "UTF-8";

	public String requestGet(String url, Map<String, String> params){
		String result = "";
		HttpClient client = new DefaultHttpClient();
	    try{
		    List<NameValuePair> paramList = convertParam(params);
		    HttpGet get = new HttpGet(url+"?"+URLEncodedUtils.format(paramList, ENCODING));
	        ResponseHandler<String> rh = new BasicResponseHandler();
	        result =  client.execute(get, rh);
        }catch(Exception e){
            result = "error";
        }finally{
            client.getConnectionManager().shutdown();
        }
		
		return result;
    }
	
	public String requestGet(String url){
		String result = "";
		HttpClient client = new DefaultHttpClient();
	    try{
		    HttpGet get = new HttpGet(url);
	        ResponseHandler<String> rh = new BasicResponseHandler();	        
	        result =  client.execute(get, rh);       	        
        }catch(Exception e){
            result = "error";
        }finally{
            client.getConnectionManager().shutdown();
        }
		
		return result;
    }	
	
	
	public String requestPost(String url, Map<String,String> params) throws Exception {
		String result = "";
		HttpClient client = new DefaultHttpClient();
		try{
			HttpPost post = new HttpPost(url);
			List<NameValuePair> paramList = convertParam(params);
			post.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
			client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, TIMEOUT_LIMIT);			
			ResponseHandler<String> rh = new BasicResponseHandler();
			result =  client.execute(post, rh);
		}catch(Exception e){
			result = "error";					
			client.getConnectionManager().shutdown();
			return result;
		}finally{
			client.getConnectionManager().shutdown();
		}
		
		return result;
	}
	
    private List<NameValuePair> convertParam(Map<String, String> params){
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        Iterator<String> keys = params.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            paramList.add(new BasicNameValuePair(key, params.get(key).toString()));
        }
         
        return paramList;
    }
    
	public String requestGetByte(String vurl){
		StringBuilder html 		= new StringBuilder(); 
		String 		result 		= "";
		HttpURLConnection conn 	= null;
		URL url 				= null;
		try {
			url = new URL(vurl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(5000);			
			conn.setDoOutput(true);
		    conn.getOutputStream();			
			conn.connect();		
			if (conn != null) {
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"euc-kr"));					
										
					while (true) {												
						String line = br.readLine();																
						if (line == null) break;
						html.append(line + '\n'); 
					}
					br.close();
					result = html.toString();
					conn.disconnect();					
				}else{
					/// 받아온 데이터를 쓰기위한 스트림
					ByteArrayOutputStream bos = new ByteArrayOutputStream( ) ;					
					InputStream err = conn.getErrorStream( ) ;
					byte[] buf = new byte[2048];					
					while( true ) {
						int readlen = err.read( buf ) ;
						 
						if ( readlen < 1 )
						break ;
						bos.write( buf, 0, readlen ) ;
					}
					 
					/// 에러메세지를 문자열로 저장
					String output = new String( bos.toByteArray( ), "EUC-KR" ) ;
					 
					/// 읽은 에러메세지를 출력한다.
					System.err.println( output ) ;					
					result = "Error";
					conn.disconnect();
				}
				
			}			

		} catch (MalformedURLException e) {
			System.out.println("001");
			System.out.println(e.getMessage());				
			result = "Error";			
		} catch (SocketTimeoutException e) {
			System.out.println("002");		
			System.out.println(e.getMessage());			
			// 2. 타임아웃
			result = "Error";			
		} catch (IOException e) {
			System.out.println("003");			
			System.out.println(e.getMessage());				
			// 3. 네트웍 문제
			result = "Error";			
		} catch (Exception e) {
			System.out.println("004 : " + e.getMessage());			
			// 4. 기타 문제
			
			result = "Error";			
		} finally{
			conn.disconnect();
		}
		return result;
    }	    
    
}
