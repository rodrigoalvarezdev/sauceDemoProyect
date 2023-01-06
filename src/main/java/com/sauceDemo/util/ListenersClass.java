package com.sauceDemo.util;

import org.openqa.selenium.Capabilities;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.sauceDemo.action.Action;

public class ListenersClass implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Capabilities capabilities = LaunchConfig.retCapabilities();
		if (ITestResult.SUCCESS == result.getStatus() ) {
			ExtentManager
			.extentTest(result.getName())
			.assignAuthor("Rodrigo alvarez")
			.assignDevice(capabilities.getBrowserName())
			.assignCategory(result.getMethod().getGroups())
			.pass(result.getName());
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Capabilities capabilities = LaunchConfig.retCapabilities();
		if(ITestResult.FAILURE == result.getStatus()) {
			ExtentManager
			.extentTest(result.getName())
			.assignAuthor("Rodrigo alvarez")
			.assignDevice(capabilities.getBrowserName())
			.assignCategory(result.getMethod().getGroups())
			.fail(result.getThrowable().toString())
			.addScreenCaptureFromBase64String(Action.screenshot());
			LogsApp.error("nombre de test "+ result.getName()+" falla: "+result.getThrowable());
		}
	}
}
