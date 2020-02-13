package utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MyExtentReports {
	public static ExtentReports reports;
	public static void setPlatformDetails(String url, String browserType) {

		//reports.setSystemInfo("User", System.getProperty("user.dir"));
		reports.setSystemInfo("URL", url);
		reports.setSystemInfo("BrowserType", browserType);

	}
	public void initExtentReports() throws IOException
	{
		try
		{
			Properties props = new Properties();

			String reportLoc="/src/main/WebContent/extentReports";

			ClassLoader loader = this.getClass().getClassLoader();
			InputStream input = loader.getResourceAsStream("config/testdata.properties");
			props.load(input);
			String dir_path;

			dir_path = System.getProperty("user.dir");
			System.out.println("dir path in extent reports init "+dir_path);
			System.out.println(dir_path + reportLoc);
			File f = new File(dir_path + reportLoc);
			if (!f.exists())
			{
				f.mkdir();
			}
			String reportFilePath;


			f = new File(dir_path + reportLoc+"/" + "bharathi.html");
			f.createNewFile();
			reportFilePath = dir_path + reportLoc+"/" + "bharathi.html";

			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFilePath);
			reports = new ExtentReports() ;
			reports.attachReporter(htmlReporter);
			// reports.addSystemInfo("Selenium Version", "2.53.1");
			//reports.addSystemInfo("Browser",browser);
			try
			{
				String env=System.getProperty("env");
				reports.setSystemInfo("Environment",env);
				if(env==null)
					reports.setSystemInfo("Environment","QA");
				System.out.println("env for reports"+env);
			}
			catch(NullPointerException e)
			{
				System.out.println("env for reports default to QA");
				reports.setSystemInfo("Environment","QA");

			}

		}

		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
}



