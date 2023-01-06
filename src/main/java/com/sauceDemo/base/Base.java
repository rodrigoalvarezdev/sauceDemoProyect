package com.sauceDemo.base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.sauceDemo.action.Action;
import com.sauceDemo.util.ExtentManager;
import com.sauceDemo.util.LaunchConfig;
import com.sauceDemo.util.LogsApp;



public class Base {
	@BeforeSuite(alwaysRun = true, groups = {"regresion"})
	public void beforeSuite() {
		ExtentManager.initReport();
		LaunchConfig.loadConfig();
		
	}
	
	@AfterSuite(alwaysRun = true, groups = {"regresion"})
	public void afterSuite(){
		//ExtentManager.extentRep().setSystemInfo("OS", System.getProperty("os.name"));
		ExtentManager.closeReport();
	}
	
	@BeforeMethod(alwaysRun = true, groups = {"regresion"})
	public void setUp(ITestContext context) {
		String suiteBrowser = context.getCurrentXmlTest().getParameter("browser");
		String browserUp = suiteBrowser != null ? suiteBrowser : "chrome";
		LaunchConfig.lauchApp(browserUp);
	}
	
	@AfterMethod(alwaysRun = true, groups = {"regresion"})
	public void tearDown(ITestResult result, ITestContext context) {
		System.out.println(result.getName());
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println(result.getThrowable());
		}else {
			System.out.println("paso "+result.getName());
		}
		LaunchConfig.getDriver().quit();
	}
}
