package com.sauceDemo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsApp {
	static Logger logs = LogManager.getLogger("LogsApp");
	public static void error(String err) {
		logs.error(err);
	}
}
