package com.automation.framework.utils;

import org.apache.logging.log4j.LogManager;

public class Log4j2Util {

	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(Log4j2Util.class);
	
	public static void info(String message) {
		logger.info(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void error(String message,  Throwable e) {
		logger.error(message, e);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}
}