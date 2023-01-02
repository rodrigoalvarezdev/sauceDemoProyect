package com.sauceDemo.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenersClass implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		if (ITestResult.SUCCESS == result.getStatus() ) {
			ExtentManager.extentTest(result.getName()).log(Status.PASS, "El test paso desde suite");
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			ExtentManager.extentTest(result.getName()).log(Status.FAIL, "el test ha fallado desde suite");
		}
	}
}
