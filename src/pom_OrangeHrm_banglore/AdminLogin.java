package pom_OrangeHrm_banglore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {

	@FindBy(id="txtUsername")
	WebElement objuser;
	@FindBy(id="txtPassword")
	WebElement objpass;
	@FindBy(id="btnLogin")
	WebElement objlogin;
	
	public void adminLogin(String user ,String pass)
	{
		objuser.clear();
		objuser.sendKeys(user);
		objpass.clear();
		objpass.sendKeys(pass);
		objlogin.sendKeys(Keys.ENTER);
	}
	
}
