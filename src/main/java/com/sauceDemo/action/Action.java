package com.sauceDemo.action;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sauceDemo.base.Base;
import com.sauceDemo.util.LaunchConfig;

public class Action extends Base{
	
	public static void click(WebElement ele) {
		if(ele.isDisplayed()) {
			ele.click();
		}else {
			System.out.println("no se encuentra el elemento");
		}
	}
	
	public static void waitVblty(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(LaunchConfig.getDriver(), Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void sendText(WebElement ele, String text) {
		if(ele.isDisplayed()) {
			ele.sendKeys(text);
		}else {
			System.out.println("no se encuentral el elemento");
		}
	}
	
	public static  String screenshot(String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot)LaunchConfig.getDriver();
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File( "data/"+name+".png");
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(destination.getPath());
		return destination.getAbsolutePath();
	}
	
	public static String screenshot() {
		TakesScreenshot takesScreenshot = (TakesScreenshot)LaunchConfig.getDriver();
		String source = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		return source;
	}
}
