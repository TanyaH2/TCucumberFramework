package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HomePage  extends BaseClass{
	@FindBy(xpath = "//li[@class='page-title']")
	public WebElement dashboardText;

	@FindBy(xpath = "//a[contains(@class,'collapsible-header')]/span[2]")
	public WebElement AdminDrDwn;

	
	@FindBy(xpath = "//div[@id='menu-content']//span[text()='PIM']")
	public WebElement pim;
	
	@FindBy(xpath = "//span[text()='Add Employee']")
	public WebElement addEmployee;
    
	
	public HomePage() {

		PageFactory.initElements(driver, this);
	}
	
}
