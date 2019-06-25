package com.orangehrm.stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {
	HomePage homePage;
	AddEmployeePage emp;

	@Given("I logged in into OrangeHRM")
	public void i_logged_in_into_OrangeHRM() {
		LoginPage login = new LoginPage();
		emp = new AddEmployeePage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		homePage = new HomePage();
		click(homePage.pim);
	}

	@When("I click on Add Employee link")
	public void i_click_on_Add_Employee_link() {
		homePage = new HomePage();
		click(homePage.addEmployee);
	}

	@When("I provide Employee details {string}, {string}, {string}, {string}")
	public void i_provide_Employee_details(String fName, String mName, String lName, String location) {
//		emp = new AddEmployeePage();

		sendText(emp.firstName, fName);
		sendText(emp.middleName, mName);
		sendText(emp.lastName, lName);
		click(emp.location);
		selectList(emp.locationList, location);

	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		click(emp.saveBtn);
	}

	@Then("I see employee {string} and {string} is added succesfully")
	public void i_see_employee_and_is_added_succesfully(String fName, String lName) {
//		emp = new AddEmployeePage();
		waitForElementBeClickable(emp.empCheck, 20);
		String verifText = emp.empCheck.getText();
		System.out.println(verifText);
		Assert.assertEquals(fName + " " + lName, verifText);

	}

	@When("I click on create login details")
	public void i_click_on_create_login_details() {
//		emp = new AddEmployeePage();
		emp.crLogDet.click();

	}

	@When("I provide all mandatory fields {string}, {string}, {string}, {string}, {string}")
	public void i_provide_all_mandatory_fields(String uName, String pass, String passconf, String ess, String superv) {
//		emp = new AddEmployeePage();
		sendText(emp.usernameLoginDetails, uName);
		sendText(emp.passwordLoginDetails, pass);
		sendText(emp.confPassLoginDetails, passconf);
		waitForElementBeVisible(emp.essRole, -400);
		click(emp.essRole);
//		selectList(emp.essRoleOpt, ess); 
		emp.essRole.sendKeys(Keys.ENTER);
		click(emp.supervisorRole);
//		selectList(emp.supervisorRoleOpt, superv);
		emp.supervisorRole.sendKeys(Keys.ENTER);
	}

	@Then("I see following labels")
	public void i_see_following_labels(DataTable addEmpLabels) {
		System.out.println("----Printing expected labels from cucumber dataTable----");
		List<String> expectedLabels = addEmpLabels.asList();
		for (String label : expectedLabels) {
			System.out.println(label);
		}
		// create an empty arraylist where we store labels text
		List<String> actualLabels = new ArrayList<String>();

		// get all label elements
//		emp = new AddEmployeePage();
		List<WebElement> labelList = emp.addEmpLabels;
		for (WebElement label : labelList) {
			String labeltxt = label.getText();
			// if text is not empty replace * and store it inside actualLabels
			if (!labeltxt.isEmpty()) {
				actualLabels.add(labeltxt.replace("*", ""));
			}
		}
		Assert.assertTrue(actualLabels.equals(expectedLabels));
	}

	@When("I provide employee details from {string}")
	public void i_provide_employee_details(String sheetName) {

		//lets say they come from excel
				/*
				 * fis
				 * workbook
				 * worksheet(sheetName)
				 * number #rows
				 * number# cols
				 * loop (rows){
				 * loop (cols){
				 *
				 * 	sendText(emp.firstName, valueFromeachCell);
					sendText(emp.middleName, valueFromeachCell);
					sendText(emp.lastName, valueFromeachCell);
					click(emp.location);
					selectList(emp.locationList, valueFromeachCell);
				 *  	
				 * 
				 * 	}
				 * }
				 */
		}
}
