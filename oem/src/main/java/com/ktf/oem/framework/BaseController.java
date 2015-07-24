package com.ktf.oem.framework;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class BaseController extends MultiActionController {
	
	/**
	 * Ŭ���̾�Ʈ���� ������ Request���� �Ķ���͸� ���Ѵ�.
	 * 
	 * @param request HttpServletRequest
	 * @param name �Ķ���͸�
	 * @return �Ķ���Ͱ�
	 */
	public String getParam(HttpServletRequest request, String name) {
		return request.getParameter(name);
	}

	/**
	 * Ŭ���̾�Ʈ���� ������ Request���� �Ķ���͸� ���Ѵ�.<br/>
	 * �Ķ���Ͱ��� ���� ��� defaultValue ���� ��ȯ�Ѵ�.
	 * 
	 * @param request HttpServletRequest
	 * @param name �Ķ���͸�
	 * @param defaultValue �Ķ���Ͱ��� ���� ��� ��ȯ�� default ��
	 * @return �Ķ���Ͱ�
	 */
	public String getParam(HttpServletRequest request, String name, String defaultValue) {
		String	value	= request.getParameter(name);

		if ((null == value) || (0 == value.length())) {
			value	= defaultValue;
		}

		return value;
	}

	/**
	 * Ŭ���̾�Ʈ�� ������ IP ���� ��ȯ�Ѵ�.
	 * 
	 * @param request the request
	 * @return remote ip �ּ�
	 */
	public String getRemoteAddr(HttpServletRequest request) {

		String	ip	= request.getHeader("X-FORWARDED-FOR");

		if ((null == ip) || "".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
			ip	= request.getRemoteAddr();
		}

		return ip;
	}

	/**
	 * Ŭ���̾�Ʈ���� ������ Request�� Body(JSON ���ڿ�)�� ���Ѵ�.
	 * 
	 * @param request HttpServletRequest
	 * @return Ŭ���̾�Ʈ���� ������ Requeet�� Body
	 */
	public String getRequestBody(HttpServletRequest request) {
		return request.getParameter("_REQ_JSON_OBJECT_");
	}

	/**
	 * JSON ���ڿ��� ��ü�� ��ȯ
	 * <pre>
	 * Example:
	 *     Single single = (Single)this.getObjectFromJSON(request, Single.class);
	 * </pre>
	 * 
	 * @param request HttpServletRequest
	 * @param beanClass ��ȯ�� ��ü�� Ÿ��
	 * @return ��ȯ�� ��ü
	 */
	public Object getObjectFromJSON(HttpServletRequest request, Class<?> beanClass) {
		return JSONObject.toBean(JSONObject.fromObject(getRequestBody(request)), beanClass);
	}

	/**
	 * JSON ���ڿ��� ��ü�� ��ȯ (List ������ �Է��� ���� ��� List �� ��ü ������ classMap ���� �Ѱ��ش�)
	 * <pre>
	 * Example:
	 *     Map classMap = new HashMap();
	 *     classMap.put("children", Children.class);
	 *     Single single = (Single)this.getObjectFromJSON(request, Single.class, classMap);
	 * </pre>
	 * 
	 * @param request HttpServletRequest
	 * @param beanClass ��ȯ�� ��ü�� Ÿ��
	 * @param classMap List ��ü ����
	 * @return ��ȯ�� ��ü
	 */
	public Object getObjectFromJSON(HttpServletRequest request, Class<?> beanClass, Map<?, ?> classMap) {
		return JSONObject.toBean(JSONObject.fromObject(getRequestBody(request)), beanClass, classMap);
	}

	/**
	 * JSON ���ڿ��� Object�� Array�� ��ȯ
	 * <pre>
	 * Example:
	 *     BoardItem[] boardItems = (BoardItem[])this.getArrayFromJSON(request, BoardItem.class);
	 * </pre>
	 * 
	 * @param request HttpServletRequest
	 * @param beanClass ��ȯ�� ��ü�� Ÿ��
	 * @return ��ȯ�� ��ü�� �迭
	 */
	public Object[] getArrayFromJSON(HttpServletRequest request, Class<?> beanClass) {
		return (Object[])JSONArray.toArray(JSONArray.fromObject(getRequestBody(request)), beanClass);
	}

	/**
	 * JSON ���ڿ��� Object�� Array�� ��ȯ (List ������ �Է��� ���� ��� List �� ��ü ������ classMap ���� �Ѱ��ش�)
	 * <pre>
	 * Example:
     *     Map classMap = new HashMap(); 
     *     classMap.put("children", Children.class); 
     *     Single[] singles = (Single[])getArrayFromJSON(request, Single.class, classMap); 
	 * </pre>
	 * 
	 * @param request HttpServletRequest
	 * @param beanClass ��ȯ�� ��ü�� Ÿ��
	 * @param classMap List ��ü ����
	 * @return ��ȯ�� ��ü�� �迭
	 */
	public Object[] getArrayFromJSON(HttpServletRequest request, Class<?> beanClass, Map<?, ?> classMap) {
		return (Object[])JSONArray.toArray(JSONArray.fromObject(getRequestBody(request)), beanClass, classMap);
	}

	/**
	 * JSON ���ڿ��� Object�� List�� ��ȯ
	 * <pre>
	 * Example:
	 *     List single = this.getListFromJSON(request, Single.class);
	 * </pre>
	 * 
	 * @param request HttpServletRequest
	 * @param beanClass ��ȯ�� ��ü�� Ÿ��
	 * @return ��ȯ�� ��ü ���
	 */
	public Object getListFromJSON(HttpServletRequest request, Class<?> beanClass) {
		return Arrays.asList(this.getArrayFromJSON(request, beanClass));
	}

	/**
	 * JSON ���ڿ��� Object�� List�� ��ȯ (List ������ �Է��� ���� ��� List �� ��ü ������ classMap ���� �Ѱ��ش�)
	 * <pre>
	 * Example:
     *     Map classMap = new HashMap(); 
     *     classMap.put("children", Children.class); 
     *     List singles = (Single[])getArrayFromJSON(request, Single.class, classMap); 
	 * </pre>
	 * 
	 * @param request HttpServletRequest
	 * @param beanClass ��ȯ�� ��ü�� Ÿ��
	 * @param classMap List ��ü ����
	 * @return ��ȯ�� ��ü�� �迭
	 */
	public Object getListFromJSON(HttpServletRequest request, Class<?> beanClass, Map<?, ?> classMap) {
		return Arrays.asList(this.getArrayFromJSON(request, beanClass, classMap));
	}

	/**
	 * ��������� JSON String�� �÷��� ������ �����ͷ� ��ȯ�Ѵ�. (beanClaass) �� �ѱ�� ���·� �����͸� ��ȯ�Ѵ�.
	 * 
	 * @param request HttpServletRequest
	 * @param beanClass ��ȯ�� ��ü�� Ÿ��
	 * @return ��ȯ�� ��ü�� �÷���
	 */
	public Object getCollectionFromJSON(HttpServletRequest request, Class<?> beanClass) {
		return JSONArray.toCollection(JSONArray.fromObject(getRequestBody(request)), beanClass);
	}

	/**
	 * UTF-8 �����͸� ���������� ��������.
	 * 
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 */
	public void outputToClient(HttpServletResponse response, String data) {
		ResponseHelper.outputToClient(response, data);
	}

	/**
	 * �����͸� ���������� ��������.
	 * 
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 * @param charset ���ڼ�
	 */
	public void outputToClient(HttpServletResponse response, String data, String charset) {
		ResponseHelper.outputToClient(response, data, charset);
	}

	/**
	 * �����͸� ���������� ��������
	 * 
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 */
	public void outputToClientHtml(HttpServletResponse response, String data) {
		ResponseHelper.outputToClientHtml(response, data, BaseConstant.DEFAULT_ENCODING);
    }

	/**
	 * �����͸� ���������� ��������
	 * 
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 * @param charset ���ڼ�
	 */
	public void outputToClientHtml(HttpServletResponse response, String data, String charset) {
		ResponseHelper.outputToClientHtml(response, data, charset);
    }

	/**
	 * UTF-8 �����͸� JSON���� ��ȯ�Ͽ� ���������� ��������.<br/>
	 * ResponseData �� ������� �ʰ� ���� data �� ��������.
	 * 
	 * @param request the request
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 */
	public void outputJSONData(HttpServletRequest request, HttpServletResponse response, Object data) {
		ResponseHelper.outputJSONData(request, response, data);
	}

	/**
	 * �����͸� JSON���� ��ȯ�Ͽ� ���������� ��������.<br/>
	 * ResponseData �� ������� �ʰ� ���� data �� ��������.
	 * 
	 * @param request the request
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 * @param charset ���ڼ�
	 */
	public void outputJSONData(HttpServletRequest request, HttpServletResponse response, Object data, String charset) {
		ResponseHelper.outputJSONData(request, response, data, charset);
	}

	/**
	 * UTF-8 �����͸� JSON���� ��ȯ�Ͽ� ���������� ��������.
	 * 
	 * @param request the request
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 */
	public void outputJSON(HttpServletRequest request, HttpServletResponse response, Object data) {
		ResponseHelper.outputJSON(request, response, data);
	}

	/**
	 * �����͸� JSON���� ��ȯ�Ͽ� ���������� ��������.
	 * 
	 * @param request the request
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 * @param charset ���ڼ�
	 */
	public void outputJSON(HttpServletRequest request, HttpServletResponse response, Object data, String charset) {
		ResponseHelper.outputJSON(request, response, data, charset);
	}

	/**
	 * ���� �߻��� UTF-8 JSON���� ��ȯ�Ͽ� ���������� ��������.
	 * 
	 * @param request the request
	 * @param response HttpServletResponse
	 * @param errCode ���� �ڵ�
	 * @param errMsg ���� �޽���
	 * @param t ���� ��ü
	 */
	public void outputJSON(HttpServletRequest request, HttpServletResponse response, String errCode, String errMsg,
			Throwable t) {
		ResponseHelper.outputJSON(request, response, errCode, errMsg, t);
	}

	/**
	 * ���� �߻��� JSON���� ��ȯ�Ͽ� ���������� ��������.
	 * 
	 * @param request the request
	 * @param response HttpServletResponse
	 * @param errCode ���� �ڵ�
	 * @param errMsg ���� �޽���
	 * @param t ���� ��ü
	 * @param charset ���ڼ�
	 */
	public void outputJSON(HttpServletRequest request, HttpServletResponse response, String errCode, String errMsg,
			Throwable t, String charset) {
		ResponseHelper.outputJSON(request, response, errCode, errMsg, t, charset);
	}

	/**
	 * �迭 Ȥ�� ����Ʈ�� JSON Array �� ��ȯ�Ͽ� ���������� ������.
	 * 
	 * @param response HttpServletResponse
	 * @param arrayOrList ���� ������
	 */
	public void outputJSONArray(HttpServletResponse response, Object arrayOrList) {
		ResponseHelper.outputJSONArray(response, arrayOrList);
	}

	/**
	 * �迭 Ȥ�� ����Ʈ�� JSON Array �� ��ȯ�Ͽ� ���������� ������.
	 * 
	 * @param response HttpServletResponse
	 * @param arrayOrList ���� ������
	 * @param charset ���ڼ�
	 */
	public void outputJSONArray(HttpServletResponse response, Object arrayOrList,
			String charset) {
		ResponseHelper.outputJSONArray(response, arrayOrList, charset);
	}

	/**
	 * UTF-8 ���䵥��Ÿ�� JSON���� ��ȯ�Ͽ� ���������� ������.
	 * 
	 * @param response HttpServletResponse
	 * @param jsonData ���� ����Ÿ ��ü
	 */
	public void outputJSONRaw(HttpServletResponse response, String jsonData) {
		ResponseHelper.outputJSONRaw(response, jsonData);
	}

	/**
	 * ���䵥��Ÿ�� JSON���� ��ȯ�Ͽ� ���������� ������.
	 * 
	 * @param response HttpServletResponse
	 * @param jsonData ���� ����Ÿ ��ü
	 * @param charset ���ڼ�
	 */
	public static void outputJSONRaw(HttpServletResponse response, String jsonData,
			String charset) {
		ResponseHelper.outputJSONRaw(response, jsonData, charset);
	}

	
	/**
	 * UTF-8 XML ���ڿ��� ���������� ������.
	 * 
	 * @param response HttpServletResponse
	 * @param xml ���� XMLS ���ڿ�
	 */
	public void outputXMLFromString(HttpServletResponse response, String xml) {
		ResponseHelper.outputXMLFromString(response, xml);
	}

	/**
	 * XML ���ڿ��� ���������� ������.
	 * 
	 * @param response HttpServletResponse
	 * @param xml ���� XMLS ���ڿ�
	 * @param charset ���ڼ�
	 */
	public void outputXMLFromString(HttpServletResponse response, String xml, String charset) {
		ResponseHelper.outputXMLFromString(response, xml, charset);
    }
	
}
