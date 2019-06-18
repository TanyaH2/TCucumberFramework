package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{
	@Test(groups = "smoke")
	public void loginToOrangeHRM() {

		LoginPageWithoutPageFactory login = new LoginPageWithoutPageFactory();

	
		CommonMethods.sendText(login.username, "Admins");
		CommonMethods.sendText(login.password, "@81EpCSguV");
		CommonMethods.click(login.btnLogin);
		
		HomePage home = new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();

		Assert.assertTrue(isDisplayed);


	}

	@Test(groups = "smoke")
	public void doLogIn()  {
	
		LoginPage login = new LoginPage();
		//Thread.sleep(10000);
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		//Thread.sleep(5000);
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		//Thread.sleep(5000);
		CommonMethods.click(login.loginBtn);
		
		
		HomePage home = new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();
		Assert.assertTrue(isDisplayed);

	}

	/*
	 * verify user is unable to logIn with wrong credentials
	 */

	@Test(groups= "smoke")
	public void negativeLogin() {
		
		LoginPage login=new LoginPage();
		
		login.login("admins", "test");
		String errorText=login.message.getText();
		
		Assert.assertEquals(errorText, "Invalid Credentials");
	}

}

