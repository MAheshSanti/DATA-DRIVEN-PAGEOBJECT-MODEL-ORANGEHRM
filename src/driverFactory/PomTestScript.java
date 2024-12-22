package driverFactory;

import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.PomPrePostcondition;
import pom_OrangeHrm_banglore.AddEmployee;
import utilities.ExcelFileUtil;

public class PomTestScript extends PomPrePostcondition {

	
	String inputpath="./FileInput\\empadd.xlsx";
	String outputpath="./Fileoutput/employeeaddresult.xlsx";
	String sheet="addemp";
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public  void startTest() throws Throwable
	{
		
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc= xl.rowCount(sheet);
		Reporter.log("no of row ="+rc);
		
		report= new ExtentReports("./report/orngHRM_AddEmp.html");
		
		
		//getting data from excel file
		
		for(int i=1;i<=rc;i++)
		{
			logger=report.startTest("Add Employee validation in orange hrm application");
			logger.assignAuthor("Mahesh Santi");
			String fstname = xl.getCellData(sheet, i, 0);
			String lstname = xl.getCellData(sheet, i, 1);

			AddEmployee a=PageFactory.initElements(driver, AddEmployee.class);
			
			logger.log(LogStatus.INFO,fstname+"xxxxxxxx"+ lstname);
			
			boolean res = a.addEmployee(fstname, lstname);
			if(res)
			{
				logger.log(LogStatus.PASS,"Employee add sucessfully");

				xl.setCellData(sheet, i, 2, "Pass", outputpath);
			}
			else
			{
				logger.log(LogStatus.FAIL,"Employee add FAIl");

				xl.setCellData(sheet, i, 2, "Fail", outputpath);

			}
			
			report.endTest(logger);
			report.flush();
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
