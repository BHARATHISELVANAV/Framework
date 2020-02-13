package driverFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.utils.FileUtil;

import utilities.InitTests;
import utilities.*;

public class Driver {
	String dir_path = null;
	public WebDriver initWebDriver (String url, String browserType) {
		WebDriver webdriver = null;
		String driverpath = null;
		url = InitTests.BASEURL;
		browserType= InitTests.BROWSER_TYPE;
		dir_path = InitTests.dir_path;


		switch (browserType) {
		case "CHROME":
			driverpath = dir_path + "/src/main/resources/drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverpath);
			webdriver = new ChromeDriver();
			webdriver.manage().window().maximize();
			webdriver.get(url);
			MyExtentReports.setPlatformDetails(url, browserType);
			return webdriver;
		}
		return webdriver;
	}

	public String getScreenPath(WebDriver driver,String testScriptName) throws IOException {
		String file = null;
		File ff = new File(dir_path + "/src/main/resourcesWebContent/extentReports/Screens");
		if(!ff.exists()) {
			ff.mkdir();
		}
		String myScreen = testScriptName + ".png";
		file = dir_path+"/src/main/resources/WebContent/extentReports/Screens/" + myScreen;
		File f = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File(file));
		
		return file;
	}
}
