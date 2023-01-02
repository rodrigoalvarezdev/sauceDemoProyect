package com.sauceDemo.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	static ExtentReports extentReports = new ExtentReports();
	public static void initReport() {;
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report\\report.html");
		extentReports.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
	}
	
	public static void closeReport() {
		extentReports.flush();
	}
	
	public static ExtentTest extentTest(String test) {
		ExtentTest test1 = extentReports.createTest(test);
		return test1;
	}
	
	public static ExtentReports extentRep() {
		return extentReports;
	}
}
