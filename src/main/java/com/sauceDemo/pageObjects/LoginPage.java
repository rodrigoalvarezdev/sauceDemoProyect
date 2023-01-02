package com.sauceDemo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauceDemo.action.Action;
import com.sauceDemo.base.Base;
import com.sauceDemo.util.LaunchConfig;

public class LoginPage extends Base {
	@FindBy(id = "user-name") WebElement userNameInput;
	@FindBy(id = "password") WebElement passwordInput;
	@FindBy(id = "login-button") WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(LaunchConfig.getDriver(), this);
	}
	
	public void loginApp(String user, String password) {
		Action.waitVblty(userNameInput);
		Action.sendText(userNameInput, user);
		Action.sendText(passwordInput, password);
		Action.click(loginBtn);
	}
}
