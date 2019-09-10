package com.atmecs.logReports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.constants.FilePath;


public class LogReport {
	Logger logger = null;

	public LogReport() {
		getlogger();
		logger = Logger.getLogger(LogReport.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(FilePath.LOG4J_FILE);
	}

	/**
	 * the method takes input as string message
	 * 
	 * @param message is printed on the console
	 */
	public void info(String message) {
		logger.info(message);
	}

}
