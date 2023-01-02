package com.sauceDemo.util;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchConfig {
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	static Properties prop;
	
	public static RemoteWebDriver getDriver() {
		return driver.get();
	}
	public static void loadConfig() {
		try {
			ExtentManager.initReport();
			prop = new Properties();
			FileInputStream F = new FileInputStream("props\\config.properties");
			prop.load(F);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void lauchApp(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		
		driver.get().manage().window().maximize();
		driver.get().get(prop.getProperty("url"));
	}
}
