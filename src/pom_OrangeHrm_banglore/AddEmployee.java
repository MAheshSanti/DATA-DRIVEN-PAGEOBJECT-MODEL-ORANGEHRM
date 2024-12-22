package pom_OrangeHrm_banglore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmployee {

	
	 WebDriver driver;
	 public AddEmployee(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	
	
	@FindBy(xpath="//b[normalize-space()='PIM']")
	WebElement objpim;
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	WebElement objaddemployee;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='employeeId']")
	WebElement employeeid;
	@FindBy(id="btnSave")
	WebElement objbtnsave;
	
	@FindBy(xpath="//a[@id='menu_pim_viewEmployeeList']")
	WebElement employeelist;
	
	@FindBy(xpath="//input[@id='empsearch_id']")
	WebElement serchtxtboxempid;
	@FindBy(xpath="//input[@id='searchBtn']")
	WebElement objsearchButton;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[2]/a")
	WebElement expempid;
	
	public boolean addEmployee(String fname, String lname) throws Throwable
	{
	Actions act= new Actions(driver);
	act.moveToElement(objpim).click().perform();
	Thread.sleep(2000);
	act.moveToElement(objaddemployee).click().perform();
	Thread.sleep(2000);

	firstname.sendKeys(fname);
	lastname.sendKeys(lname);
	String actempid=employeeid.getAttribute("value");
	Reporter.log(actempid);
	objbtnsave.sendKeys(Keys.ENTER);
	
	Thread.sleep(2000);

	act.moveToElement(employeelist).click().perform();
	Thread.sleep(2000);

	serchtxtboxempid.sendKeys(actempid);
	
	objsearchButton.click();
	Thread.sleep(2000);

	String expempidno= expempid.getText();
	
	if(actempid.equals(expempidno))
	{
		Reporter.log("Add employee sucessfully"+"==="+actempid+"===="+expempidno,true);
		return true;

		
	}
	else
	{
		Reporter.log("Add employee FAIL"+"==="+actempid+"===="+expempidno,true);
		return false;

	}
	
	
	
	
	}
	
	
	
}
