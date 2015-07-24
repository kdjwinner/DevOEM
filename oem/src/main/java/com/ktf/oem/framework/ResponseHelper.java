package com.ktf.oem.framework;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.ktf.oem.framework.BaseConstant;

public class ResponseHelper {


	/**
	 * UTF-8 �����͸� ���������� ��������
	 * 
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 */
	public static void outputToClient(HttpServletResponse response, String data) {
		outputToClient(response, data, BaseConstant.DEFAULT_ENCODING);
	}

	/**
	 * �����͸� ���������� ��������
	 * 
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 * @param charset ���ڼ�
	 */
	public static void outputToClient(HttpServletResponse response, String data, String charset) {
		response.setCharacterEncoding(charset);

		if (response.containsHeader("IESupportJsonHack")) {
			//IE ���۵����� ���� �ӽú���
			response.setContentType("text/html; charset=" + charset);
			//response.setContentType("text/plain : charset=" + charset);
			response.resetBuffer();
		}

		PrintWriter	out	= null;

		try {
			out	= new PrintWriter(new OutputStreamWriter(response.getOutputStream(), charset), true);
			out.print(data);
			out.flush();
		} catch (Exception e) {
			response.setStatus(500);	// Internal server error
			e.printStackTrace(System.out);
		} finally {
			if (null != out) {
				out.close();
			}
        }
    }

	/**
	 * �����͸� ���������� ��������
	 * 
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 */
	public static void outputToClientHtml(HttpServletResponse response, String data) {
		outputToClientHtml(response, data, BaseConstant.DEFAULT_ENCODING);
    }

	/**
	 * �����͸� ���������� ��������
	 * 
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 * @param charset ���ڼ�
	 */
	public static void outputToClientHtml(HttpServletResponse response, String data, String charset) {
		response.setCharacterEncoding(charset);

		PrintWriter	out	= null;

		try {
			response.setContentType("text/html");

			out	= new PrintWriter(new OutputStreamWriter(response.getOutputStream(), charset), true);
			out.print(data);
			out.flush();
		} catch (Exception e) {
			response.setStatus(500);	// Internal server error
			e.printStackTrace(System.out);
		} finally {
			if (null != out) {
				out.close();
			}
        }
    }

	/**
	 * UTF-8 �����͸� JSON���� ��ȯ�Ͽ� ���������� ��������.<br/>
	 * ResponseData �� ������� �ʰ� ���� data �� ��������.
	 * 
	 * @param request the request
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 */
	public static void outputJSONData(HttpServletRequest request, HttpServletResponse response, Object data) {
		outputJSONData(request, response, data, BaseConstant.DEFAULT_ENCODING);
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
	public static void outputJSONData(HttpServletRequest request, HttpServletResponse response,
			Object data, String charset) {
		response.setContentType("application/json; charset=" + charset);

		// JsonConfig ����(Java Date Ÿ���� yyyy.MM.dd HH:mm:ss ���·� ��ȯ�Ѵ�.)
		JsonValueProcessor	beanProcessor	= new JavaUtilDateJsonValueProcessor();
		JsonConfig			jsonConfig		= new JsonConfig();

		jsonConfig.registerJsonValueProcessor(java.util.Date.class, beanProcessor);

		String	jsonData	= JSONObject.fromObject(data, jsonConfig).toString();

		outputToClient(response, jsonData);
    }

	/**
	 * UTF-8 �����͸� JSON���� ��ȯ�Ͽ� ���������� ��������.
	 * 
	 * @param request the request
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 */
	public static void outputJSON(HttpServletRequest request, HttpServletResponse response, Object data) {
		outputJSON(request, response, data, BaseConstant.DEFAULT_ENCODING);
	}

	/**
	 * �����͸� JSON���� ��ȯ�Ͽ� ���������� ��������.
	 * 
	 * @param request the request
	 * @param response HttpServletResponse
	 * @param data ������ ���� ������
	 * @param charset ���ڼ�
	 */
	public static void outputJSON(HttpServletRequest request, HttpServletResponse response,
			Object data, String charset) {
		response.setContentType("application/json; charset=" + charset);

		ResponseData	resData	= new ResponseData();

		resData.setSessionId(request.getSession().getId());

		if (data instanceof Object[] || data instanceof java.util.List) {
			resData.setData(getJSONArrayString(data));
		} else {
			resData.setData(data);
		}

		resData.setResponseCode(BaseConstant.SUCCESS_CD);
		resData.setResponseText(BaseConstant.SUCCESS_NM);

		// JsonConfig ����(Java Date Ÿ���� yyyy.MM.dd HH:mm:ss ���·� ��ȯ�Ѵ�.)
		JsonValueProcessor	beanProcessor	= new JavaUtilDateJsonValueProcessor();
		JsonConfig			jsonConfig		= new JsonConfig();

		jsonConfig.registerJsonValueProcessor(java.util.Date.class, beanProcessor);

		String	jsonData	= JSONObject.fromObject(resData, jsonConfig).toString();
		outputToClient(response, jsonData);
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
	public static void outputJSON(HttpServletRequest request, HttpServletResponse response,
			String errCode, String errMsg, Throwable t) {
		outputJSON(request, response, errCode, errMsg, t, BaseConstant.DEFAULT_ENCODING);
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
	public static void outputJSON(HttpServletRequest request, HttpServletResponse response,
			String errCode, String errMsg, Throwable t, String charset) {
		response.setContentType("application/json; charset=" + charset);

		ResponseData	resData	= new ResponseData();

		resData.setSessionId(request.getSession().getId());
		resData.setResponseCode(errCode);
		resData.setResponseText(errMsg);

		ByteArrayOutputStream	bos	= new ByteArrayOutputStream();
		PrintStream				ps	= new PrintStream(bos);

		t.printStackTrace(ps);
		resData.setSystemError(bos.toString());

		// JsonConfig ����(Java Date Ÿ���� yyyy.MM.dd HH:mm:ss ���·� ��ȯ�Ѵ�.)
		JsonValueProcessor	beanProcessor	= new JavaUtilDateJsonValueProcessor();
		JsonConfig			jsonConfig		= new JsonConfig();

		jsonConfig.registerJsonValueProcessor(java.util.Date.class, beanProcessor);

		String	jsonData	= JSONObject.fromObject(resData, jsonConfig).toString();

		outputToClient(response, jsonData);
	}

	/**
	 * �迭 Ȥ�� ����Ʈ�� JSON Array �� ��ȯ�Ͽ� ���������� ������
	 *   
	 * @param response HttpServletResponse
	 * @param arrayOrList ���� ������
	 */
	public static void outputJSONArray(HttpServletResponse response, Object arrayOrList) {
		outputJSONArray(response, JSONArray.fromObject(arrayOrList).toString(),
				BaseConstant.DEFAULT_ENCODING);
	}

	/**
	 * �迭 Ȥ�� ����Ʈ�� JSON Array �� ��ȯ�Ͽ� ���������� ������
	 *   
	 * @param response HttpServletResponse
	 * @param arrayOrList ���� ������
	 * @param charset ���ڼ�
	 */
	public static void outputJSONArray(HttpServletResponse response, Object arrayOrList,
			String charset) {
		outputJSONRaw(response, getJSONArrayString(arrayOrList), charset);
	}

	/**
	 * UTF-8 ���䵥��Ÿ�� JSON���� ��ȯ�Ͽ� ���������� ������.
	 * 
	 * @param response HttpServletResponse
	 * @param jsonData ���� ����Ÿ ��ü
	 */
	public static void outputJSONRaw(HttpServletResponse response, String jsonData) {
		outputJSONRaw(response, jsonData, BaseConstant.DEFAULT_ENCODING);
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
		response.setContentType("application/json; charset=" + charset);
		outputToClient(response, jsonData, charset);
	}

	/**
	 * UTF-8 XML ���ڿ��� ���������� ������.
	 * 
	 * @param response HttpServletResponse
	 * @param xml ���� XMLS ���ڿ�
	 */
	public static void outputXMLFromString(HttpServletResponse response, String xml) {
		outputXMLFromString(response, xml, BaseConstant.DEFAULT_ENCODING);
	}

	/**
	 * XML ���ڿ��� ���������� ������.
	 * 
	 * @param response HttpServletResponse
	 * @param xml ���� XMLS ���ڿ�
	 * @param charset ���ڼ�
	 */
	public static void outputXMLFromString(HttpServletResponse response, String xml, String charset) {
		response.setContentType("text/xml; charset=" + charset);
		outputToClient(response, xml);
    }

	/**
	 * Array Data �� JSON ���ڿ��� ��ȯ
	 * 
	 * @param data ��ü �迭
	 * @return ��ȯ�� JSON ���ڿ�
	 */
	private static String getJSONArrayString(Object data) {
		JsonValueProcessor	beanProcessor	= new JavaUtilDateJsonValueProcessor();
		JsonConfig			jsonConfig		= new JsonConfig();

		jsonConfig.registerJsonValueProcessor(java.util.Date.class, beanProcessor);

		return JSONArray.fromObject(data, jsonConfig).toString();
	}
}
