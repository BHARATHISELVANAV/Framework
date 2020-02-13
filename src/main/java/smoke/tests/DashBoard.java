package smoke.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import driverFactory.Driver;
import utilities.InitTests;
import verify.SoftAssertions;

import static utilities.MyExtentReports.reports;

import java.io.File;
import java.io.IOException;

public class DashBoard extends InitTests{
	public static WebDriver webdriver = null;
	public static Driver driverObj = null;
	ExtentTest test;


	public static WebDriver driver = null;

	


	@Test(enabled = true)
	public void DashBoard() throws IOException {
		try {
			String reportLoc="/src/main/resources/WebContent/extentReports";
			File f = new File(dir_path + reportLoc+"/" + "bharathi.html");
			f.createNewFile();
			String reportFilePath = dir_path + reportLoc+"/" + "bharathi.html";

			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFilePath);
			reports = new ExtentReports() ;
			reports.attachReporter(htmlReporter);

			test = reports.createTest("Test1");
			test.assignCategory("Smoke");
			driverObj = new Driver();
			webdriver = driverObj.initWebDriver(BASEURL, BROWSER_TYPE);
			webdriver.findElement(By.xpath("//dasfasdf")).click();
			
			

		}
		catch(Error e) {
			e.printStackTrace();
			SoftAssertions.fail(driverObj.getScreenPath(webdriver, new Exception().getStackTrace()[0].getMethodName()), test);
			softAssert.assertAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			SoftAssertions.fail(driverObj.getScreenPath(webdriver, new Exception().getStackTrace()[0].getMethodName()), test);
		}
		finally{
			reports.flush();
		}








	}

}
