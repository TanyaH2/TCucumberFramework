package com.orangehrm.stepDefinitions;

import org.openqa.selenium.By;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps extends BaseClass {

	@Given("I navigated to Google.com")
	public void i_navigated_to_Google_com() {
		setUp();
		
	   //System.out.println("I'm on Google page");
	}

	@When("I type searcg item")
	public void i_type_searcg_item() {
		CommonMethods.sendText(driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")), "Yamaha MT 07");
		System.out.println("I search for item");
	}

	@When("I click on google search button")
	public void i_click_on_google_search_button() {
		CommonMethods.click(driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']/center/input[1]")));
		System.out.println("Clicked search btn");
	}

	@Then("I see search results are displayed")
	public void i_see_search_results_are_displayed() {
		boolean result=driver.findElement(By.id("resultStats")).isDisplayed();
		
		if(result=true) {
			System.out.println("Your search was succesfull");
		}else {
			System.out.println("Something went wrong");
		}
		tearDown();
		
	
	}

}
