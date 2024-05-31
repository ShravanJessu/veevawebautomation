package com.automation.framework;

import org.apache.logging.log4j.LogManager;

public class Logger {

	private static final Logger logger =  (Logger) LogManager.getLogger(Logger.class);

	public static void info(String message) {
		logger.info(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void error(String message, Exception e) {
		logger.error(message, e);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}
}