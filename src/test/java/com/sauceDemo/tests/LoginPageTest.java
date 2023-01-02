package com.sauceDemo.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.sauceDemo.base.Base;
import com.sauceDemo.pageObjects.LoginPage;
import com.sauceDemo.util.DataProviderClass;

public class LoginPageTest extends Base {
	
	@Test(dataProvider = "excelData", dataProviderClass = DataProviderClass.class, enabled = true, groups = {"regresion"})
	public void loginPageTest(String user, String password) {
		LoginPage loginPage = new LoginPage();
		loginPage.loginApp(user, password);
		Assert.assertTrue(true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
