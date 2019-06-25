package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.syntax.utils.BaseClass;

public class AddEmployeePage extends BaseClass{
	
	@FindBy(id="firstName")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
    public WebElement location;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
    
//    @FindBy(xpath="//input[@id='chkLogin']")
//    public WebElement createLoginDetails;
    
    @FindBy(xpath="//label[@for='hasLoginDetails']")
    public WebElement crLogDet;
  
    @FindBy (css="input#username")
    public WebElement  usernameLoginDetails;
    
    @FindBy (css="input#password")
    public WebElement  passwordLoginDetails;
    
    @FindBy (css="input#confirmPassword")
    public WebElement  confPassLoginDetails;
    
    @FindBy (xpath="//div[@id='essRoleId_inputfileddiv']//input")
    public WebElement  essRole;
    
    @FindBy(xpath="//form[@id='pimAddEmployeeForm']//label")
    public List<WebElement> addEmpLabels;
    
    
    @FindBy (xpath="//div[@class='select-wrapper initialized']//ul[@class='dropdown-content select-dropdown']")
    public WebElement  essRoleOpt;
    
    @FindBy (xpath="//div[@id='supervisorRoleId_inputfileddiv']//input")
    public WebElement  supervisorRole;
    
    @FindBy (xpath="//div[@class='select-wrapper initialized']//ul[contains(@id,'fae-c')]")
    public WebElement  supervisorRoleOpt;
  
    @FindBy(id="systemUserSaveBtn")
    public WebElement saveBtn;
    
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empCheck;
    
    public AddEmployeePage() {
        PageFactory.initElements(driver,this);
    }
}