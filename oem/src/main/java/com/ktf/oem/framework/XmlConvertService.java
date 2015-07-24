package com.ktf.oem.framework;

import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;

@Service("xmlConvertService")
public class XmlConvertService {

	public String objectToString(Object obj, String ari){
		String xml = "";
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);		
		//xstream.alias(ari, obj.getClass());
		xml = xstream.toXML(obj);
		return xml;
	}	
	
	public Object xmlToClass(Object paramClass, String xml, String ari){
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(false);
//		xstream.alias(ari, paramClass.getClass());

		Object obj = paramClass.getClass();
		obj = xstream.fromXML(xml);
		return obj;
	}
	
	public Object xmlToClass(Object paramClass, String xml){
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(false);
//		xstream.alias(ari, paramClass.getClass());

		Object obj = paramClass.getClass();
		obj = xstream.fromXML(xml);
		return obj;
	}	
	
	
}
