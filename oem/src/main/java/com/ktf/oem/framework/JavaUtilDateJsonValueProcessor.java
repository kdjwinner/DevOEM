package com.ktf.oem.framework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;


public class JavaUtilDateJsonValueProcessor implements JsonValueProcessor {
	/** ����Ʈ ���� ���� */
	private DateFormat	defaultDateFormat	= null;

	/**
	 * ������ (Java Date Ÿ���� yyyy.MM.dd HH:mm:ss ���·� ��ȯ�Ѵ�.)
	 */
	public JavaUtilDateJsonValueProcessor() {
		this.defaultDateFormat	= new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
	}

    @Override
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		if (null == value) {
			return null;
		}

		return this.defaultDateFormat.format(value);
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		return processArrayValue(value, jsonConfig);
	}
}
