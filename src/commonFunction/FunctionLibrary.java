package commonFunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil {
	
	
	public static boolean adminLogin(String userid,String passwd) throws Throwable
	{
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(p.getProperty("url"));

		Thread.sleep(3000);

		driver.findElement(By.id(p.getProperty("objuser"))).sendKeys(userid);
		driver.findElement(By.id(p.getProperty("objpass"))).sendKeys(passwd);
		driver.findElement(By.id(p.getProperty("objlogin"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		String exp="dashboard";
		String act= driver.getCurrentUrl();
		if(act.contains(exp))
		{
			Reporter.log("Valid username and password"+exp+"==="+act,true);

			driver.findElement(By.xpath(p.getProperty("objwelcome"))).click();;
			Thread.sleep(1000);

			driver.findElement(By.linkText(p.getProperty("objlogout"))).click();
			Thread.sleep(1000);

			return true;

		}
		else
		{
			Reporter.log("inValid username and password"+exp+"==="+act,true);

			String errmsg=driver.findElement(By.xpath(p.getProperty("objerr"))).getText();
			Reporter.log(errmsg);
			return false;

		}
		

	}

}
