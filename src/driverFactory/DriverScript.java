package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunction.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil{
	
	
	String inputpath="./FileInput\\olgin.xlsx";
	String outputpath="./Fileoutput/orangehrmLogin.xlsx";
	
	ExtentReports report;
	ExtentTest logger;

	
	@Test
	public void startTest() throws Throwable
	{
		report = new ExtentReports("./report/orangeHrmLogin.html");
		logger=report.startTest("Validate admin login");
		logger.assignAuthor("Mahesh Santi");
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc= xl.rowCount("LoginData");
		for(int i=1;i<=rc;i++)
		{
			String username =xl.getCellData("LoginData", i, 0);
			String password =xl.getCellData("LoginData", i, 1);
			
			boolean res= FunctionLibrary.adminLogin(username,password);
			if(res)
			{
				Reporter.log("Login Sucessfull");
				xl.setCellData("LoginData", i, 2, " Valid user and pass" , outputpath);
				xl.setCellData("LoginData", i, 3, "pass" , outputpath);
				logger.log(LogStatus.PASS,username, password+"Login Sucessful");
			}
			else
			{
				Reporter.log("Login unSucessfull");
				xl.setCellData("LoginData", i, 2, " InValid user and pass" , outputpath);
				xl.setCellData("LoginData", i, 3, "fail" , outputpath);
				logger.log(LogStatus.FAIL,username, password+"login FAIL");

			}

			report.endTest(logger);
			report.flush();
			
		}
		
	}
	
	

}
