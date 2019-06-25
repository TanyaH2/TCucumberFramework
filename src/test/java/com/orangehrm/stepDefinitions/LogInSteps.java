package com.orangehrm.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LogInSteps extends CommonMethods {

	LoginPage login;
	
	
	@Given("I navigated to OrangeHRM")
	public void i_navigated_to_OrangeHRM() {
		setUp();

	}

	@Given("I see OrangeHRM logo")
	public void i_see_OrangeHRM_logo() {
		login = new LoginPage();
		boolean isDisplayed = login.logo.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("I enter valid userName and password")
	public void i_enter_valid_userName_and_password() {
		
		sendText(login.userName, "Admin");
		sendText(login.password, "@81EpCSguV");
	}

	@When("I click login Btn")
	public void i_click_login_Btn() {
	click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		HomePage home= new HomePage();
		Assert.assertTrue(home.dashboardText.isDisplayed());
	}
	
	
	@When("I enter invalid userName and password")
	public void i_enter_invalid_userName_and_password() {
		sendText(login.userName, "Test");
		sendText(login.password, "123");
	}

	@Then("I see error message is displayed")
	public void i_see_error_message_is_displayed() {
		Assert.assertTrue(login.message.isDisplayed());
		String errorT = login.message.getText().trim();
		Assert.assertEquals("Invalid Credentials",errorT);
		System.out.println(errorT);
	}
	@Then("I close browser")
	public void i_close_browser() {
	   tearDown();
	}
	@When("I enter invalid username and password I see the errorMessage")
	public void i_enter_invalid_username_and_password_I_see_the_errorMessage(DataTable wrongCredentials) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
	   List<Map<String,String>>maps=wrongCredentials.asMaps();
	   for(Map<String,String> map:maps) {
		 //printing values of each key
			System.out.println(map.get("UserName"));
			System.out.println(map.get("Password"));
			System.out.println(map.get("ErrorMessage"));
			System.out.println("------------------------------");
			//passing username and password values from datatable/map
		   sendText(login.userName, map.get("UserName"));
		   sendText(login.password, map.get("Password"));
		   click(login.loginBtn);
		 //verifying text of error message
		   String actErr=login.message.getText().trim();
		   String expErr=map.get("ErrorMessage");
		   Assert.assertEquals(expErr, actErr);
	   }
	   
	}
	
}
