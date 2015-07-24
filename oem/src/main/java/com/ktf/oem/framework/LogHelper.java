package com.ktf.oem.framework;

import org.apache.log4j.Logger;


public class LogHelper {
	/**
	 * Logging Error
	 * 
	 * @param obj ��¿� ����� ��ü(Object)
	 * @param msg ����� �޽���(String)
	 */
	public static void error(Object obj, String msg) {
		Logger	logger	= Logger.getLogger(obj.getClass());
		logger.error(msg);
	}

	/**
	 * Logging Fatal
	 * 
	 * @param obj ��¿� ����� ��ü(Object)
	 * @param msg ����� �޽���(String)
	 */
	public static void fatal(Object obj, String msg) {
		Logger	logger	= Logger.getLogger(obj.getClass());
		logger.fatal(msg);
	}

	/**
	 * Logging Info.
	 * 
	 * @param obj ��¿� ����� ��ü(Object)
	 * @param msg ����� �޽���(String)
	 */
	public static void info(Object obj, String msg) {
		Logger	logger	= Logger.getLogger(obj.getClass());
		logger.info(msg);
	}

	/**
	 * Logging Debug
	 * 
	 * @param obj ��¿� ����� ��ü(Object)
	 * @param msg ����� �޽���(String)
	 */
	public static void debug(Object obj, String msg) {
		Logger	logger	= Logger.getLogger(obj.getClass());
		logger.debug(msg);
	}

	/**
	 * Logging Error
	 * 
	 * @param cls ��¿� ����� Ŭ����(Class)
	 * @param msg ����� �޽���(String)
	 */
	public static void error(Class<?> cls, String msg) {
		Logger	logger	= Logger.getLogger(cls);
		logger.error(msg);
	}

	/**
	 * Logging Fatal
	 * 
	 * @param cls ��¿� ����� Ŭ����(Class)
	 * @param msg ����� �޽���(String)
	 */
	public static void fatal(Class<?> cls, String msg) {
		Logger	logger	= Logger.getLogger(cls);
		logger.fatal(msg);
	}

	/**
	 * Logging Info.
	 * 
	 * @param cls ��¿� ����� Ŭ����(Class)
	 * @param msg ����� �޽���(String)
	 */
	public static void info(Class<?> cls, String msg) {
		Logger	logger	= Logger.getLogger(cls);
		logger.info(msg);
	}

	/**
	 * Logging Debug
	 * 
	 * @param cls ��¿� ����� Ŭ����(Class)
	 * @param msg ����� �޽���(String)
	 */
	public static void debug(Class<?> cls, String msg) {
		Logger	logger	= Logger.getLogger(cls);
		logger.debug(msg);
	}
}
