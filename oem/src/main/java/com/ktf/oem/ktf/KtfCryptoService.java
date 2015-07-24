package com.ktf.oem.ktf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import JKTFCrypto.JKTFCrypto;

import com.ktf.oem.framework.LogHelper;

@Service("kyfCryptoService")
public class KtfCryptoService {
	/*
			algo 1 	"SEED";
			algo 2:	"3DES";
			algo 3:	"DES";
			algo 4: "AES128";
			
			algo������ 1,4�� ��� �ϰ� ����(jsp ���� ������)
			hashId 256:  "SHA1";
			hashId 512:  "SHA256";
			default:	return "Unknown";
			
			algoId�� ��ȣȭ �� �� ���
			hashId �� hash �ڵ�� ���� �� ���
	 * 
	 * */

	public Map<String, String> ktEncryptoMap(String param, int algoId) throws Exception {
		JKTFCrypto crypto 		= new JKTFCrypto();
		Map<String, String> map	= new HashMap<String, String>();	
		String keyid = crypto.getKeyId();	
		String encSessionKey = crypto.CreateSessionKey();
		
		if (crypto.getErrorCode() < 0 || encSessionKey == null) {
			
		}
		
		// Encrypt Data
		crypto.setCipherAlgorithm(algoId);
		
		byte [] btdata  = param.getBytes();
		String encdata = crypto.EncryptData(btdata);
		if (crypto.getErrorCode() < 0 || encdata == null){
			
		}		
		crypto.release();	
		map.put("ring_keyid", keyid);
		map.put("ring_encid", encSessionKey);
		map.put("ctn", encdata);
		
		return map;
	}
	
	public String ktDecrtpyto(String keyid, String enckey, String param) throws Exception {
		//��ȣȭ �߰�
		JKTFCrypto crypto = new JKTFCrypto();
		crypto.setKeyId(keyid);
		crypto.DecryptSessionKey(enckey);
		byte[] decmsg = crypto.DecryptData(param);
		String return_data = new String(decmsg);
		
		crypto.release();
		
		return return_data;
	}	
	
	private String getAlgoName (int algo){
		switch (algo)
		{
			case 1:	return 	"SEED";
			case 2:	return 	"3DES";
			case 3:	return 	"DES";
			case 4:	return "AES128";
			case 256: return "SHA1";
			case 512: return "SHA256";
			default:	return "Unknown";
		}	
		
	
	}
}
