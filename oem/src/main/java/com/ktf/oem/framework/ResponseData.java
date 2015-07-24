package com.ktf.oem.framework;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ResponseData {
	/** ���Ǿ��̵� �����Ѵ�. */
	private String	sessionId;
	/** ���� �ڵ� : ������ ��� 0�� �ǵ�����. */
	private String	responseCode;
	/** ���� �޽��� : ������ ��� '���������� ó���Ǿ����ϴ�.'�� �ǵ�����. */
	private String	responseText;
	/** �ý��� ������ ��� �ý��� ������ �ǵ�����. */
	private String	systemError;
	/** ���� ����Ÿ. */
	private Object data;

	/**
	 * ���Ǿ��̵� getter
	 * 
	 * @return ���Ǿ��̵�
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * ���Ǿ��̵� setter
	 * 
	 * @param sessionId ���Ǿ��̵�
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * ���� �ڵ� getter
	 * 
	 * @return ���� �ڵ�
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * ���� �ڵ� setter
	 * 
	 * @param responseCode ���� �ڵ�
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * ���� �޽��� getter
	 * 
	 * @return ���� �޽���
	 */
	public String getResponseText() {
		return responseText;
	}

	/**
	 * ���� �޽��� setter
	 * 
	 * @param responseText ���� �޽���
	 */
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	/**
	 * �ý��� ���� getter
	 * 
	 * @return �ý��� ����
	 */
	public String getSystemError() {
		return systemError;
	}

	/**
	 * �ý��� ���� setter
	 * 
	 * @param systemError �ý��� ����
	 */
	public void setSystemError(String systemError) {
		this.systemError = systemError;
	}

	/**
	 * ���� ������ getter
	 * 
	 * @return ���� ������
	 */
	public Object getData() {
		return data;
	}

	/**
	 * ���� ������ setter
	 * 
	 * @param data ���� ������
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * Bean �����͸� ���ڿ��� ��ȯ�Ѵ�.
	 * 
	 * @return Bean ������ ���ڿ�
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
