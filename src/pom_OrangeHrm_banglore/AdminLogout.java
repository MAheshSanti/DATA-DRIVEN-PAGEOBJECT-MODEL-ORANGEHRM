package pom_OrangeHrm_banglore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {

	@FindBy(xpath="//a[@id='welcome']")
	WebElement objwelcome;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement objlogout;
	
	public void adminLogout() throws Throwable
	{
		objwelcome.click();
		Thread.sleep(2000);
		objlogout.click();
	}
	
}
