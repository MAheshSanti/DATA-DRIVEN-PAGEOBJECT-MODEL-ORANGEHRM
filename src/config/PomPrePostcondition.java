package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pom_OrangeHrm_banglore.AdminLogin;
import pom_OrangeHrm_banglore.AdminLogout;

public class PomPrePostcondition {

	public static WebDriver driver;
	public static Properties p;
	
	@BeforeTest
	public static void setup() throws Throwable
	{
		p= new Properties();
		p.load(new FileInputStream("./PropertyFile\\Enviornment.properties"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(p.getProperty("url"));
		
		AdminLogin login = PageFactory.initElements(driver, AdminLogin.class);
		login.adminLogin("Admin", "Qedge123!@#");
	}

	@AfterTest
	public static void taerDown() throws Throwable
	{
		AdminLogout logout = PageFactory.initElements(driver, AdminLogout.class);
		logout.adminLogout();
		driver.quit();
	}
	
	
	
	
	
}
